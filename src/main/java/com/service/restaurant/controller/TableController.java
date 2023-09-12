package com.service.restaurant.controller;

import com.service.restaurant.entity.TableEntity;
import com.service.restaurant.modal.TableDetail;
import com.service.restaurant.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping("/tables/{id}")
    public TableDetail getTable(@PathVariable Long id) {
        return tableService.getTableById(id);
    }

    @PostMapping("/table")
    public TableDetail createNewTable(@RequestBody TableDetail tableDetail) {
        return tableService.createNewTable(tableDetail);
    }

    @PatchMapping("/table")
    public TableDetail updateTable(@RequestBody TableDetail tableDetail) {
        return tableService.updateTable(tableDetail);
    }

    @DeleteMapping("/table")
    public TableDetail deleteTable(@RequestBody TableDetail tableDetail) {
        return tableService.deleteTable(tableDetail);
    }
}
