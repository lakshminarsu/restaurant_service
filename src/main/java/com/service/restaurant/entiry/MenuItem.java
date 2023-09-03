package com.service.restaurant.entiry;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "main_menu_item_id", nullable = false)
    private Long mainMenuItemId;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "item_price")
    private Long itemPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMainMenuItemId() {
        return mainMenuItemId;
    }

    public void setMainMenuItemId(final Long mainMenuItemId) {
        this.mainMenuItemId = mainMenuItemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(final String itemName) {
        this.itemName = itemName;
    }

    public Long getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(final Long itemPrice) {
        this.itemPrice = itemPrice;
    }
}
