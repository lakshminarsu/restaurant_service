package com.service.restaurant.modal.request;

import com.service.restaurant.modal.BillItem;
import com.service.restaurant.modal.MenuItem;

import java.util.List;

public class CreateOrderRequest {
    private Long tableId;
    private List<BillItem> items;

    public Long getTableId() {
        return tableId;
    }

    public void setTableId(final Long tableId) {
        this.tableId = tableId;
    }

    public List<BillItem> getItems() {
        return items;
    }

    public void setItems(final List<BillItem> items) {
        this.items = items;
    }
}
