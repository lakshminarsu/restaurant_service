package com.service.restaurant;

import com.service.restaurant.entiry.MainMenu;
import com.service.restaurant.repository.MainMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {
    @Autowired
    private MainMenuRepository mainMenuRepository;

    public List<MainMenu> getMainMenuItems() {
        return mainMenuRepository.findAll();
    }
}
