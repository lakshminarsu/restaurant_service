package com.service.restaurant.service;

import com.service.restaurant.entity.TableEntity;
import com.service.restaurant.modal.Bill;
import com.service.restaurant.modal.TableDetail;
import com.service.restaurant.repository.TableRepository;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TableService {
    @Autowired
    private TableRepository tableRepository;

    public List<TableDetail> getAllTables() {
        List<TableEntity> tableEntities = tableRepository.findAll();
        List<TableDetail> tableDetails = tableEntities.stream().map(te->convertEntityToModal(te)).collect(Collectors.toList());
        return tableDetails;
    }

    private TableDetail convertEntityToModal(TableEntity tableEntity) {
        TableDetail tableDetail = new TableDetail();
        tableDetail.setId(tableEntity.getId());
        tableDetail.setName(tableEntity.getName());
        tableDetail.setSequence(tableEntity.getSequence());
        //Id 1 is dummy id
        //Table is free. No bill is associated
        if (tableEntity.getBill().getId() != 1) {
            Bill bill = new Bill();
            bill.setId(tableEntity.getBill().getId());
            bill.setPrice(tableEntity.getBill().getPrice());
            bill.setStatus(tableEntity.getBill().getStatus());
            bill.setCreatedTime(tableEntity.getBill().getCreatedTime());
            tableDetail.setBill(bill);
        }
        return tableDetail;
    }
}
