package com.service.restaurant.controller;

import com.service.restaurant.modal.Bill;
import com.service.restaurant.modal.TableDetail;
import com.service.restaurant.modal.request.CreateOrderRequest;
import com.service.restaurant.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
public class BillController {
    @Autowired
    private BillService billService;

    @PostMapping("/bill")
    public TableDetail createNewOrder(@RequestBody CreateOrderRequest createOrderRequest) {
        return billService.createNewOrder(createOrderRequest);
    }

    @PutMapping("/bill")
    public Bill modifyBill(@RequestBody Bill bill) {
        return billService.modifyBill(bill);
    }

    @GetMapping("/bill/{id}")
    public Bill getBill(@PathVariable Long id) {
        return billService.getBill(id);
    }

    @GetMapping("/bills/{billDate}")
    public List<Bill> getBills(@PathVariable String billDate) throws ParseException { return billService.getBillsByDate(billDate); }
}
