package com.service.restaurant.modal;

public class MenuItem {
    private Long id;
    private Long mainMenuItemId;
    private String itemName;
    private Long itemPrice;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
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
