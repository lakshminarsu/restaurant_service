package com.service.restaurant.entity;

import com.service.restaurant.modal.Bill;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity(name = "bill_item")
public class BillItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "item_id")
    private MenuItemEntity menuItemEntity;

    @ManyToOne
    @JoinColumn(name = "bill_id")
    private BillEntity billEntity;
    //@JoinColumn(name = "bill_id")
    //private BillEntity billEntity;
    //@Column(name = "bill_id")
    //private Long billId;

    @Column(name = "qty")
    private Long qty;

    @Column(name = "item_desc")
    private String desc;

    public MenuItemEntity getMenuItemEntity() {
        return menuItemEntity;
    }

    public void setMenuItemEntity(MenuItemEntity menuItemEntity) {
        this.menuItemEntity = menuItemEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /*public Long getBillId() {
        return billId;
    }

    public void setBillId(final Long billId) {
        this.billId = billId;
    }*/

    public Long getQty() {
        return qty;
    }

    public void setQty(final Long qty) {
        this.qty = qty;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(final String desc) {
        this.desc = desc;
    }

    public BillEntity getBillEntity() {
        return billEntity;
    }

    public void setBillEntity(final BillEntity billEntity) {
        this.billEntity = billEntity;
    }
}
