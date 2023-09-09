package com.service.restaurant.controller;

import com.service.restaurant.modal.BillItem;
import com.service.restaurant.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BillController {
    @Autowired
    private BillService billService;

    @GetMapping("/billitems/{billId}")
    public List<BillItem> getBillsByBillId(@PathVariable Long billId) {
        return billService.getBillItemsByBillId(billId);
    }
}
