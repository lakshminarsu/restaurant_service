package com.service.restaurant.repository;

import com.service.restaurant.entiry.MainMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainMenuRepository extends JpaRepository<MainMenu, Long> {
}
