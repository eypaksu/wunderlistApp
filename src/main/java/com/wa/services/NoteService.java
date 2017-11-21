package com.wa.services;

import com.wa.domain.Note;
import com.wa.domain.User;

import java.util.List;

public interface NoteService {
    List<Note> getNoteListByUserId(Long userId);

    void saveOrUpdate(Note note);

}
