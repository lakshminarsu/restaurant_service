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
import java.util.stream.Collectors;

import static com.service.restaurant.converter.ConvertUtils.convertEntityToModal;

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

    public Boolean deleteMainMenu(final Long id) {
        MainMenuEntity mainMenuEntity = mainMenuRepository.findById(id).get();
        mainMenuRepository.delete(mainMenuEntity);
        return true;
    }

    public MenuItem createMenuItem(final MenuItem menuItem) {
        MenuItemEntity menuItemEntity = new MenuItemEntity();
        menuItemEntity.setMainMenuItemId(menuItem.getMainMenuItemId());
        menuItemEntity.setItemName(menuItem.getItemName());
        menuItemEntity.setItemPrice(menuItem.getItemPrice());
        return convertEntityToModal(menuItemsRepository.saveAndFlush(menuItemEntity));
    }

    public Boolean deleteMenuItem(final Long id) {
        MenuItemEntity menuItemEntity = menuItemsRepository.findById(id).get();
        menuItemsRepository.delete(menuItemEntity);
        return true;
    }

    public MenuItem getMenuItemById(final Long id) {
        return convertEntityToModal(menuItemsRepository.findById(id).get());
    }

    public List<MenuItem> getAllMenuItems() {
        List<MenuItemEntity> menuItemEntities = menuItemsRepository.findAll();
        List<MenuItem> menuItems =
        menuItemEntities.stream().map(mi->convertEntityToModal(mi)).collect(Collectors.toList());
        return menuItems;
    }

    public MainMenu updateMainMenuItem(final MainMenu mainMenu) {
        MainMenuEntity mainMenuEntity =
                mainMenuRepository.findById(mainMenu.getId()).get();
        mainMenuEntity.setItemName(mainMenu.getItemName());
        return convertEntityToModal(mainMenuRepository.saveAndFlush(mainMenuEntity));
    }

    public MenuItem updateMenuItem(final MenuItem menuItem) {
        MenuItemEntity menuItemEntity =
                menuItemsRepository.findById(menuItem.getId()).get();
        menuItemEntity.setItemName(menuItem.getItemName());
        menuItemEntity.setItemPrice(menuItem.getItemPrice());
        return convertEntityToModal(menuItemsRepository.saveAndFlush(menuItemEntity));
    }
}
