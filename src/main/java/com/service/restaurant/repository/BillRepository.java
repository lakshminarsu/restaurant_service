package com.service.restaurant.repository;

import com.service.restaurant.entity.BillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface BillRepository extends JpaRepository<BillEntity, Long> {
    @Query("select b from bill b where DATE(b.createdTime) = :createdTime")
    public List<BillEntity> findAllByCreatedTime(@Param("createdTime") Date createdTime);
}
