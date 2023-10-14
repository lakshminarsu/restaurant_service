package com.service.restaurant.repository;

import com.service.restaurant.entity.NoteTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteTypeRepository extends JpaRepository<NoteTypeEntity, Long> {
}
