package com.service.restaurant.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Entity(name = "bill")
public class BillEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    //@OneToMany(targetEntity = BillItemEntity.class)
    @OneToMany(mappedBy="billEntity")
    private List<BillItemEntity> billItems;

    @Column(name = "price")
    public Long price;

    @Column(name = "status")
    public String status;

    @Column(name = "created_time", nullable = false, updatable = false)
    @CreationTimestamp
    public Date createdTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public List<BillItemEntity> getBillItems() {
        return billItems;
    }

    public void setBillItems(final List<BillItemEntity> billItems) {
        this.billItems = billItems;
    }
}
