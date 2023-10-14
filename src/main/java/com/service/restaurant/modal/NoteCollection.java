package com.service.restaurant.modal;

public class NoteCollection {
    private Long Id;
    private NoteType noteType;
    private Long qty;

    public Long getId() {
        return Id;
    }

    public void setId(final Long id) {
        Id = id;
    }

    public NoteType getNoteType() {
        return noteType;
    }

    public void setNoteType(final NoteType noteType) {
        this.noteType = noteType;
    }

    public Long getQty() {
        return qty;
    }

    public void setQty(final Long qty) {
        this.qty = qty;
    }
}
