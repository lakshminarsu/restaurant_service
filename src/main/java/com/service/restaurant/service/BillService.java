package com.service.restaurant.service;

import com.service.restaurant.entity.BillItemEntity;
import com.service.restaurant.modal.BillItem;
import com.service.restaurant.modal.MenuItem;
import com.service.restaurant.repository.BillItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BillService {
    @Autowired
    private BillItemRepository billItemRepository;

    public List<BillItem> getBillItemsByBillId(final Long billId) {
        List<BillItemEntity> billItemEntities = billItemRepository.findByBillId(billId);
        return billItemEntities.stream().map(bi->convertEntityToModal(bi)).collect(Collectors.toList());
    }

    private BillItem convertEntityToModal(final BillItemEntity billItemEntity) {
        BillItem billItem = new BillItem();
        billItem.setId(billItemEntity.getId());
        billItem.setBillId(billItemEntity.getBillId());
        billItem.setQty(billItemEntity.getQty());

        MenuItem menuItem = new MenuItem();
        menuItem.setId(billItemEntity.getMenuItemEntity().getId());
        menuItem.setItemPrice(billItemEntity.getMenuItemEntity().getItemPrice());
        menuItem.setItemName(billItemEntity.getMenuItemEntity().getItemName());
        menuItem.setMainMenuItemId(billItemEntity.getMenuItemEntity().getMainMenuItemId());
        billItem.setMenuItem(menuItem);

        return billItem;
    }
}
