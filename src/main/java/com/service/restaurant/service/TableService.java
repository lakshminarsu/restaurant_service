package com.service.restaurant.service;

import com.service.restaurant.converter.ConvertUtils;
import com.service.restaurant.entity.BillEntity;
import com.service.restaurant.entity.TableEntity;
import com.service.restaurant.modal.Bill;
import com.service.restaurant.modal.TableDetail;
import com.service.restaurant.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.service.restaurant.converter.ConvertUtils.convertEntityToModal;

@Service
public class TableService {
    @Autowired
    private TableRepository tableRepository;

    public TableDetail createNewTable(final TableDetail tableDetail) {
        TableEntity tableEntity = ConvertUtils.convertModalToEntity(tableDetail);
        return convertEntityToModal(tableRepository.saveAndFlush(tableEntity));
    }

    public TableDetail updateTable(final TableDetail tableDetail) {
        TableEntity tableEntity = tableRepository.findById(tableDetail.getId()).get();
        tableEntity.setName(tableDetail.getName());
        tableEntity.setSequence(tableDetail.getSequence());
        return convertEntityToModal(tableRepository.saveAndFlush(tableEntity));
    }

    public TableDetail deleteTable(final TableDetail tableDetail) {
        tableRepository.deleteById(tableDetail.getId());
        return tableDetail;
    }

    public void resetTable(final Long billId) {
        TableEntity tableDetail = tableRepository.findByBillId(billId);
        if (tableDetail != null) {
            tableDetail.setBill(null);
            tableRepository.saveAndFlush(tableDetail);
        }
    }

    public TableDetail getTableById(final Long id) {
        return convertEntityToModal(tableRepository.findById(id).get());
    }

    public TableDetail updateTableWithBill(final Long tableId, final BillEntity billEntity) {
        TableEntity tableEntity = tableRepository.findById(tableId).get();
        tableEntity.setBill(billEntity);
        return convertEntityToModal(tableRepository.saveAndFlush(tableEntity));
    }

    public List<TableDetail> getAllTables() {
        List<TableEntity> tableEntities = tableRepository.findAll();
        List<TableDetail> tableDetails = tableEntities.stream().map(te->convertEntityToModal(te)).collect(Collectors.toList());
        return tableDetails;
    }
}
