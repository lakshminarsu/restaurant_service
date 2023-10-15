package com.service.restaurant.controller;

import com.service.restaurant.modal.NoteCollection;
import com.service.restaurant.modal.NoteType;
import com.service.restaurant.service.NoteService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
public class NoteController {
    @Autowired
    private NoteService noteService;

    @GetMapping("/noteTypes")
    public List<NoteType> getNoteTypes() {
        return noteService.getNoteTypes();
    }

    @PostMapping("/noteType")
    public NoteType createNoteType(@RequestBody NoteType noteType) {
        return noteService.createNoteType(noteType);
    }

    @PatchMapping("/noteType")
    public NoteType updateNoteType(@RequestBody NoteType noteType) {
        return noteService.updateNoteType(noteType);
    }

    @DeleteMapping("/noteType/{id}")
    public Boolean deleteMapping(@PathVariable Long id) {
        return noteService.deleteNoteType(id);
    }

    @PostMapping("/noteCollection")
    public List<NoteCollection> addNoteCollection(@RequestBody List<NoteCollection> noteCollections) {
        return noteService.addNoteCollection(noteCollections);
    }

    @GetMapping("/noteCollection/{date}")
    public List<NoteCollection> getNoteCollectionByDate(@PathVariable String date) throws ParseException {
        return noteService.getNoteCollectionByDate(date);
    }


}
