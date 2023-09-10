package com.service.restaurant.repository;

import com.service.restaurant.entity.BillItemEntity;
import com.service.restaurant.entity.MenuItemEntity;
import com.service.restaurant.modal.BillItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillItemRepository extends JpaRepository<BillItemEntity, Long> {

    //public List<BillItemEntity> findByBillId(Long billId);
}
