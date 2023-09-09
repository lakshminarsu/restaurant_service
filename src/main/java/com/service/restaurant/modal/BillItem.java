package com.service.restaurant.modal;

public class BillItem {
    private Long id;
    private Long billId;
    private MenuItem menuItem;

    private Long qty;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Long getBillId() {
        return billId;
    }

    public void setBillId(final Long billId) {
        this.billId = billId;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(final MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public Long getQty() {
        return qty;
    }

    public void setQty(final Long qty) {
        this.qty = qty;
    }
}
