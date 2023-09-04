package com.service.restaurant.repository;

import com.service.restaurant.entity.MainMenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainMenuRepository extends JpaRepository<MainMenuEntity, Long> {
}
