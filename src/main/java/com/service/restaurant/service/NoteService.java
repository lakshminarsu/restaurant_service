package com.service.restaurant.service;

import com.service.restaurant.entity.NoteCollectionEntity;
import com.service.restaurant.entity.NoteTypeEntity;
import com.service.restaurant.modal.NoteCollection;
import com.service.restaurant.modal.NoteType;
import com.service.restaurant.repository.NoteCollectionRepository;
import com.service.restaurant.repository.NoteTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.service.restaurant.converter.ConvertUtils.convertEntityToModal;
import static com.service.restaurant.converter.ConvertUtils.convertModalToEntity;

@Service
public class NoteService {
    @Autowired
    private NoteTypeRepository noteTypeRepository;
    @Autowired
    private NoteCollectionRepository noteCollectionRepository;

    public NoteType createNoteType(NoteType noteType) {
        NoteTypeEntity noteTypeEntity = convertModalToEntity(noteType);
        return convertEntityToModal(noteTypeRepository.saveAndFlush(noteTypeEntity));
    }

    public NoteType updateNoteType(NoteType noteType) {
        NoteTypeEntity noteTypeEntity = noteTypeRepository.findById(noteType.getId()).get();
        noteTypeEntity.setType(noteType.getType());
        return convertEntityToModal(noteTypeRepository.saveAndFlush(noteTypeEntity));
    }

    public Boolean deleteNoteType(final Long id) {
        NoteTypeEntity noteTypeEntity = noteTypeRepository.findById(id).get();
        noteTypeRepository.delete(noteTypeEntity);
        return true;
    }

    public List<NoteCollection> addNoteCollection(final List<NoteCollection> noteCollections) {
        List<NoteCollectionEntity> noteCollectionEntities =
            noteCollections.stream().map(n->convertModalToEntity(n)).collect(Collectors.toList());
        List<NoteCollectionEntity> newNoteCollectionEntities =
                noteCollectionRepository.saveAllAndFlush(noteCollectionEntities);
        return newNoteCollectionEntities.stream().map(n->convertEntityToModal(n)).collect(Collectors.toList());
    }
}
