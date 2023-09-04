package com.service.restaurant.service;

import com.service.restaurant.entity.MainMenuEntity;
import com.service.restaurant.entity.MenuItemEntity;
import com.service.restaurant.modal.MainMenu;
import com.service.restaurant.modal.MenuItem;
import com.service.restaurant.repository.MainMenuRepository;
import com.service.restaurant.repository.MenuItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {
    @Autowired
    private MainMenuRepository mainMenuRepository;

    @Autowired
    private MenuItemsRepository menuItemsRepository;

    public List<MainMenuEntity> getMainMenuItems() {
        return mainMenuRepository.findAll();
    }

    public List<MenuItemEntity> getMenuItemsByMainMenuId(final Long mainMenuItemid) {
        return menuItemsRepository.findByMainMenuItemId(mainMenuItemid);
    }

    public MainMenu createMainMenuItem(final MainMenu mainMenu) {
        MainMenuEntity mainMenuEntity = new MainMenuEntity();
        mainMenuEntity.setItemName(mainMenu.getItemName());
        return convertEntityToModal(mainMenuRepository.saveAndFlush(mainMenuEntity));
    }

    private MainMenu convertEntityToModal(final MainMenuEntity mainMenuEntity) {
        MainMenu mainMenu = new MainMenu();
        mainMenu.setId(mainMenuEntity.getId());
        mainMenu.setItemName(mainMenuEntity.getItemName());
        return mainMenu;
    }

    public MenuItem createMenuItem(final MenuItem menuItem) {
        MenuItemEntity menuItemEntity = new MenuItemEntity();
        menuItemEntity.setMainMenuItemId(menuItem.getMainMenuItemId());
        menuItemEntity.setItemName(menuItem.getItemName());
        menuItemEntity.setItemPrice(menuItem.getItemPrice());
        return convertEntityToModal(menuItemsRepository.saveAndFlush(menuItemEntity));
    }

    private MenuItem convertEntityToModal(final MenuItemEntity menuItemEntity) {
        MenuItem menuItem = new MenuItem();
        menuItem.setId(menuItemEntity.getId());
        menuItem.setMainMenuItemId(menuItemEntity.getMainMenuItemId());
        menuItem.setItemName(menuItemEntity.getItemName());
        menuItem.setItemPrice(menuItemEntity.getItemPrice());
        return menuItem;
    }
}
