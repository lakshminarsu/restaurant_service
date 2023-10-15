package com.service.restaurant.repository;

import com.service.restaurant.entity.NoteCollectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface NoteCollectionRepository extends JpaRepository<NoteCollectionEntity, Long> {
    @Query("select nc from note_collection nc where DATE(nc.createdTime) = :createdTime")
    public List<NoteCollectionEntity> findAllByCreatedTime(@Param("createdTime") Date createdTime);
}
