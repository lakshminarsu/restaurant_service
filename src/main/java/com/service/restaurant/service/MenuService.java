package com.service.restaurant.service;

import com.service.restaurant.entiry.MainMenu;
import com.service.restaurant.entiry.MenuItem;
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

    public List<MainMenu> getMainMenuItems() {
        return mainMenuRepository.findAll();
    }

    public List<MenuItem> getMenuItemsByMainMenuId(final Long mainMenuItemid) {
        return menuItemsRepository.findByMainMenuItemId(mainMenuItemid);
    }
}
