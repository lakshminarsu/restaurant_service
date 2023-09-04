package com.service.restaurant.repository;

import com.service.restaurant.entity.MenuItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuItemsRepository extends JpaRepository<MenuItemEntity, Long> {
    public List<MenuItemEntity> findByMainMenuItemId(Long mainMenuItemId);
}
