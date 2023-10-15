package com.service.restaurant.controller;

import com.service.restaurant.entity.MenuItemEntity;
import com.service.restaurant.modal.MainMenu;
import com.service.restaurant.modal.MenuItem;
import com.service.restaurant.service.MenuService;
import com.service.restaurant.entity.MainMenuEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenuController {
    @Autowired
    private MenuService menuService;

    @GetMapping("/mainmenu")
    public List<MainMenuEntity> getMainMenuItems() {
        return menuService.getMainMenuItems();
    }

    @PostMapping("/mainmenu")
    public MainMenu createMainMenuItem(@RequestBody MainMenu mainMenu) {
        return menuService.createMainMenuItem(mainMenu);
    }

    @PatchMapping("/mainmenu")
    public MainMenu updateMainMenuItem(@RequestBody MainMenu mainMenu) {
        return menuService.updateMainMenuItem(mainMenu);
    }

    @GetMapping("/mainmenu/{id}")
    public List<MenuItemEntity> getMenuItems(@PathVariable Long id) {
        return menuService.getMenuItemsByMainMenuId(id);
    }

    @DeleteMapping("/mainmenu/{id}")
    public boolean deleteMainMenu(@PathVariable Long id) {
        return menuService.deleteMainMenu(id);
    }

    @PostMapping("/menuitem")
    public MenuItem createMenuItem(@RequestBody MenuItem menuItem) {
        return menuService.createMenuItem(menuItem);
    }

    @PatchMapping("/menuitem")
    public MenuItem updateMenuItem(@RequestBody MenuItem menuItem) {
        return menuService.updateMenuItem(menuItem);
    }

    @DeleteMapping("/menuitem/{id}")
    public Boolean deleteMenuItem(@PathVariable Long id) {
        return menuService.deleteMenuItem(id);
    }

    @GetMapping("/menuitem/{id}")
    public MenuItem getMenuItemById(@PathVariable Long id) {
        return menuService.getMenuItemById(id);
    }

    @GetMapping("/menuitems")
    public List<MenuItem> getAllMenuItems() {
        return menuService.getAllMenuItems();
    }
}
