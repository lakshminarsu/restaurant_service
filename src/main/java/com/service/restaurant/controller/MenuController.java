package com.service.restaurant.controller;

import com.service.restaurant.MenuService;
import com.service.restaurant.entiry.MainMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenuController {
    @Autowired
    private MenuService menuService;

    @GetMapping("/mainmenu")
    public List<MainMenu> getMainMenuItems() {
        return menuService.getMainMenuItems();
    }
}
