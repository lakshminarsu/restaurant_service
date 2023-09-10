package com.service.restaurant.service;

import com.service.restaurant.entity.BillEntity;
import com.service.restaurant.entity.TableEntity;
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
