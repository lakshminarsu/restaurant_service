package com.service.restaurant.modal;

import java.util.Date;
import java.util.List;

public class Bill {
    private Long id;
    private Long price;
    private String status;
    private Date createdTime;

    private List<BillItem> items;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(final Long price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(final Date createdTime) {
        this.createdTime = createdTime;
    }

    public List<BillItem> getItems() {
        return items;
    }

    public void setItems(final List<BillItem> items) {
        this.items = items;
    }
}
