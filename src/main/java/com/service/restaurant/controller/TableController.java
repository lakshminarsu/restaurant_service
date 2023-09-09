package com.service.restaurant.controller;

import com.service.restaurant.entity.TableEntity;
import com.service.restaurant.modal.TableDetail;
import com.service.restaurant.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TableController {
    @Autowired
    private TableService tableService;

    @GetMapping("/tables")
    public List<TableDetail> getAllTables() {
        return tableService.getAllTables();
    }
}
