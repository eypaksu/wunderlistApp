package com.wa.services;

import com.wa.domain.Note;
import com.wa.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteServiceImpl implements  NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public Note saveOrUpdate(Note note){
        noteRepository.save(note);
        return note;
    }

}
