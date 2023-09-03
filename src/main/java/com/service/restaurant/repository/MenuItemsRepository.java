package com.service.restaurant.repository;

import com.service.restaurant.entiry.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuItemsRepository extends JpaRepository<MenuItem, Long> {
    public List<MenuItem> findByMainMenuItemId(Long mainMenuItemId);
}
