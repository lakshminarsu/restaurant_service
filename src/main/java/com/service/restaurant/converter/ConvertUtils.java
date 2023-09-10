package com.service.restaurant.converter;

import com.service.restaurant.entity.BillEntity;
import com.service.restaurant.entity.BillItemEntity;
import com.service.restaurant.entity.MainMenuEntity;
import com.service.restaurant.entity.MenuItemEntity;
import com.service.restaurant.entity.TableEntity;
import com.service.restaurant.modal.Bill;
import com.service.restaurant.modal.BillItem;
import com.service.restaurant.modal.MainMenu;
import com.service.restaurant.modal.MenuItem;
import com.service.restaurant.modal.TableDetail;

import java.util.List;
import java.util.stream.Collectors;

public class ConvertUtils {
    public static TableDetail convertEntityToModal(TableEntity tableEntity) {
        TableDetail tableDetail = new TableDetail();
        tableDetail.setId(tableEntity.getId());
        tableDetail.setName(tableEntity.getName());
        tableDetail.setSequence(tableEntity.getSequence());
        //Id 1 is dummy id
        //Table is free. No bill is associated
        if (tableEntity.getBill().getId() != 1) {
            Bill bill = new Bill();
            bill.setId(tableEntity.getBill().getId());
            bill.setPrice(tableEntity.getBill().getPrice());
            bill.setStatus(tableEntity.getBill().getStatus());
            bill.setCreatedTime(tableEntity.getBill().getCreatedTime());
            tableDetail.setBill(bill);

            if (tableEntity.getBill().getBillItems() != null) {
                List<BillItem> billItems =
                        tableEntity.getBill().getBillItems().stream().map(bi->convertEntityToModal(bi)).collect(Collectors.toList());
                bill.setItems(billItems);
            }
        }
        return tableDetail;
    }


    public static BillEntity convertModalToEntity(final Bill bill) {
        BillEntity billEntity = new BillEntity();
        billEntity.setPrice(bill.getPrice());
        billEntity.setStatus(bill.getStatus());
        billEntity.setCreatedTime(bill.getCreatedTime());

        List<BillItemEntity> billItemEntities =
        bill.getItems().stream().map(bi->convertModalToEntity(bi, billEntity)).collect(Collectors.toList());
        billEntity.setBillItems(billItemEntities);
        return billEntity;
    }

    public static Bill convertEntityToModal(final BillEntity billEntity) {
        Bill bill = new Bill();
        bill.setId(billEntity.getId());
        bill.setPrice(billEntity.getPrice());
        bill.setStatus(billEntity.getStatus());
        bill.setCreatedTime(billEntity.getCreatedTime());

        if (billEntity.getBillItems() != null) {
            List<BillItem> billItems =
                    billEntity.getBillItems().stream().map(bi->convertEntityToModal(bi)).collect(Collectors.toList());
            bill.setItems(billItems);
        }
        return bill;
    }

    public static BillItem convertEntityToModal(final BillItemEntity billItemEntity) {
        BillItem billItem = new BillItem();
        billItem.setId(billItemEntity.getId());
        billItem.setBillId(billItemEntity.getBillEntity().getId());
        billItem.setQty(billItemEntity.getQty());

        MenuItem menuItem = new MenuItem();
        menuItem.setId(billItemEntity.getMenuItemEntity().getId());
        menuItem.setItemPrice(billItemEntity.getMenuItemEntity().getItemPrice());
        menuItem.setItemName(billItemEntity.getMenuItemEntity().getItemName());
        menuItem.setMainMenuItemId(billItemEntity.getMenuItemEntity().getMainMenuItemId());
        billItem.setMenuItem(menuItem);

        return billItem;
    }

    public static BillItemEntity convertModalToEntity(final BillItem billItem, final BillEntity billEntity) {
        BillItemEntity billItemEntity = new BillItemEntity();
        MenuItemEntity menuItemEntity = new MenuItemEntity();
        menuItemEntity.setId(billItem.getMenuItem().getId());
        menuItemEntity.setItemPrice(billItem.getMenuItem().getItemPrice());
        menuItemEntity.setItemName(billItem.getMenuItem().getItemName());
        menuItemEntity.setMainMenuItemId(billItem.getMenuItem().getMainMenuItemId());

        billItemEntity.setBillEntity(billEntity);
        billItemEntity.setMenuItemEntity(menuItemEntity);
        billItemEntity.setQty(billItem.getQty());
        return billItemEntity;
    }

    public static MainMenu convertEntityToModal(final MainMenuEntity mainMenuEntity) {
        MainMenu mainMenu = new MainMenu();
        mainMenu.setId(mainMenuEntity.getId());
        mainMenu.setItemName(mainMenuEntity.getItemName());
        return mainMenu;
    }

    public static MenuItem convertEntityToModal(final MenuItemEntity menuItemEntity) {
        MenuItem menuItem = new MenuItem();
        menuItem.setId(menuItemEntity.getId());
        menuItem.setMainMenuItemId(menuItemEntity.getMainMenuItemId());
        menuItem.setItemName(menuItemEntity.getItemName());
        menuItem.setItemPrice(menuItemEntity.getItemPrice());
        return menuItem;
    }
}
