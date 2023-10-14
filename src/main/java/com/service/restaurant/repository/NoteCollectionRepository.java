package com.service.restaurant.repository;

import com.service.restaurant.entity.NoteCollectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteCollectionRepository extends JpaRepository<NoteCollectionEntity, Long> {
}
