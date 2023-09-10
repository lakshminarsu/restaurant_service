package com.service.restaurant.repository;

import com.service.restaurant.entity.BillEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<BillEntity, Long> {
}
