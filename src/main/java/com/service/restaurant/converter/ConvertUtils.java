package com.service.restaurant.converter;

import com.service.restaurant.entity.BillEntity;
import com.service.restaurant.entity.BillItemEntity;
import com.service.restaurant.entity.MainMenuEntity;
import com.service.restaurant.entity.MenuItemEntity;
import com.service.restaurant.entity.NoteCollectionEntity;
import com.service.restaurant.entity.NoteTypeEntity;
import com.service.restaurant.entity.TableEntity;
import com.service.restaurant.modal.Bill;
import com.service.restaurant.modal.BillItem;
import com.service.restaurant.modal.MainMenu;
import com.service.restaurant.modal.MenuItem;
import com.service.restaurant.modal.NoteCollection;
import com.service.restaurant.modal.NoteType;
import com.service.restaurant.modal.TableDetail;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
        if (tableEntity.getBill() != null) {
            Bill bill = new Bill();
            bill.setId(tableEntity.getBill().getId());
            bill.setPrice(tableEntity.getBill().getPrice());
            bill.setStatus(tableEntity.getBill().getStatus());
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss aa");
            if (tableEntity.getBill().getCreatedTime() != null) {
                String strDate = dateFormat.format(tableEntity.getBill().getCreatedTime());
                bill.setCreatedTime(strDate);
            }
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

        if (bill.getItems() != null) {
            List<BillItemEntity> billItemEntities =
                    bill.getItems().stream().map(bi->convertModalToEntity(bi, billEntity)).collect(Collectors.toList());
            billEntity.setBillItems(billItemEntities);
        }
        return billEntity;
    }

    public static Bill convertEntityToModal(final BillEntity billEntity) {
        Bill bill = new Bill();
        bill.setId(billEntity.getId());
        bill.setPrice(billEntity.getPrice());
        bill.setStatus(billEntity.getStatus());
        bill.setTakeAway(billEntity.getTakeAway());
        if (billEntity.getCreatedTime() != null) {
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss aa");
            String strDate = dateFormat.format(billEntity.getCreatedTime());
            bill.setCreatedTime(strDate);
        }

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
        billItem.setDesc(billItemEntity.getDesc());

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
        billItemEntity.setDesc(billItem.getDesc());
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

    public static TableEntity convertModalToEntity(final TableDetail tableDetail) {
        TableEntity tableEntity = new TableEntity();
        tableEntity.setName(tableDetail.getName());
        tableEntity.setSequence(tableDetail.getSequence());
        if (tableDetail.getBill() != null) {
            BillEntity billEntity = convertModalToEntity(tableDetail.getBill());
            tableEntity.setBill(billEntity);
        }

        return tableEntity;
    }

    public static NoteTypeEntity convertModalToEntity(final NoteType noteType) {
        NoteTypeEntity noteTypeEntity = new NoteTypeEntity();
        noteTypeEntity.setId(noteType.getId());
        noteTypeEntity.setType(noteType.getType());

        return noteTypeEntity;
    }

    public static NoteType convertEntityToModal(final NoteTypeEntity noteTypeEntity) {
        NoteType noteType = new NoteType();
        noteType.setType(noteTypeEntity.getType());
        noteType.setId(noteTypeEntity.getId());
        return noteType;
    }

    public static NoteCollectionEntity convertModalToEntity(final NoteCollection noteCollection) {
        NoteCollectionEntity noteCollectionEntity = new NoteCollectionEntity();
        noteCollectionEntity.setId(noteCollection.getId());
        noteCollectionEntity.setQty(noteCollection.getQty());
        NoteTypeEntity noteTypeEntity = new NoteTypeEntity();
        noteTypeEntity.setId(noteCollection.getNoteType().getId());
        noteTypeEntity.setType(noteCollection.getNoteType().getType());
        noteCollectionEntity.setNoteEntity(noteTypeEntity);
        return noteCollectionEntity;
    }

    public static NoteCollection convertEntityToModal(final NoteCollectionEntity noteCollectionEntity) {
        NoteCollection noteCollection = new NoteCollection();
        noteCollection.setId(noteCollectionEntity.getId());
        noteCollection.setQty(noteCollectionEntity.getQty());
        NoteType noteType = new NoteType();
        noteType.setId(noteCollectionEntity.getNoteEntity().getId());
        noteType.setType(noteCollectionEntity.getNoteEntity().getType());
        noteCollection.setNoteType(noteType);
        return noteCollection;
    }
}
