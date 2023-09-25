package com.service.restaurant.service;

import com.service.restaurant.entity.BillEntity;
import com.service.restaurant.entity.BillItemEntity;
import com.service.restaurant.modal.Bill;
import com.service.restaurant.modal.BillItem;
import com.service.restaurant.modal.TableDetail;
import com.service.restaurant.modal.request.CreateOrderRequest;
import com.service.restaurant.repository.BillItemRepository;
import com.service.restaurant.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.service.restaurant.converter.ConvertUtils.convertEntityToModal;
import static com.service.restaurant.converter.ConvertUtils.convertModalToEntity;

@Service
public class BillService {
    @Autowired
    private BillItemRepository billItemRepository;

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private TableService tableService;

    public List<Bill> getBillsByDate(final String billDate) throws ParseException {
        List<BillEntity> bills = billRepository.findAllByCreatedTime(
                new SimpleDateFormat("dd-MM-yyyy").parse(billDate));

        return bills.stream().map(b->convertEntityToModal(b)).collect(Collectors.toList());
    }

    @Transactional
    public Bill modifyBill(final Bill bill) {
        //delete all bill items
        BillEntity billEntity = billRepository.findById(bill.getId()).get();
        List<Long> billItemIds =
                billEntity.getBillItems().stream().map(bi->bi.getId()).collect(Collectors.toList());
        billItemRepository.deleteAllById(billItemIds);

        List<BillItemEntity> billItemEntities = new ArrayList<>();
        if (bill.getItems().size() > 0) {
            for (BillItem item : bill.getItems()) {
                billItemEntities.add(convertModalToEntity(item, billEntity));
            }
            billItemEntities = billItemRepository.saveAllAndFlush(billItemEntities);
            List<BillItem> billItems =
                    billItemEntities.stream().map(bi->convertEntityToModal(bi)).collect(Collectors.toList());
            bill.setItems(billItems);

            billEntity.setBillItems(billItemEntities);
            Long totalPrice=0L;
            for (BillItem item : billItems) {
                totalPrice += item.getMenuItem().getItemPrice() * item.getQty();
            }
            billEntity.setPrice(totalPrice);
            billRepository.saveAndFlush(billEntity);
        }

        return bill;


        //List<BillItemEntity> billItemEntities
          //      = bill.getItems().stream().map(bi->convertModalToEntity(bi, billEntity)).collect(Collectors.toList());
        //billEntity.setBillItems(billItemEntities);
        //BillEntity billEntity = convertModalToEntity(bill);
        //return convertEntityToModal(billRepository.saveAndFlush(billEntity));
        /*List<Long> billItemIds =
        bill.getItems().stream().map(bi->bi.getBillId()).collect(Collectors.toList());
        billItemRepository.deleteAllById(billItemIds);*/

    }

    @Transactional
    public Bill completeBill(final Long billId) {
        final String status = "closed";
        BillEntity billEntity = billRepository.findById(billId).get();
        if (!billEntity.getStatus().equals(status)) {
            billEntity.setStatus(status);
            billEntity = billRepository.saveAndFlush(billEntity);
        }
        return convertEntityToModal(billEntity);
    }

    @Transactional
    public TableDetail createNewOrder(CreateOrderRequest createOrderRequest) {
        //Create Bill
        BillEntity billEntity = new BillEntity();
        billEntity.setStatus("open");
        List<BillItem> items = createOrderRequest.getItems();
        Long totalPrice=0L;
        for (BillItem item : items) {
            totalPrice += item.getMenuItem().getItemPrice() * item.getQty();
        }
        billEntity.setPrice(totalPrice);
        billEntity = billRepository.saveAndFlush(billEntity);
        Bill bill = convertEntityToModal(billEntity);
        //Add bill items to bill
        List<BillItemEntity> billItemEntities = new ArrayList<>();
        if (items.size() > 0) {
            for (BillItem item : items) {
                billItemEntities.add(convertModalToEntity(item, billEntity));
            }
            if (billItemEntities.size() > 0) {
                billItemEntities = billItemRepository.saveAllAndFlush(billItemEntities);
            }
            List<BillItem> billItems =
                    billItemEntities.stream().map(bi->convertEntityToModal(bi)).collect(Collectors.toList());
            bill.setItems(billItems);
        }
        TableDetail tableDetail = null;
        //Update table with the new bill
        if (createOrderRequest.getTableId() > 0) {
            tableDetail =
                    tableService.updateTableWithBill(createOrderRequest.getTableId(), billEntity);
        } else {
            tableDetail = new TableDetail();
        }
        tableDetail.setBill(bill);
        return tableDetail;
    }

    public Bill addNewBill(final Bill bill) {
        BillEntity billEntity = convertModalToEntity(bill);
        return convertEntityToModal(billRepository.saveAndFlush(billEntity));
    }


    public Bill getBill(final Long id) {
        return convertEntityToModal(billRepository.findById(id).get());
    }
}
