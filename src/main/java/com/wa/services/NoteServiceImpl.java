package com.wa.services;

import com.wa.domain.Note;
import com.wa.domain.User;
import com.wa.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteServiceImpl implements  NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private UserService userService;

    public Note saveOrUpdate(Note noteParam){
        Note note = new Note();
        note.setUser(userService.findById(noteParam.getUser().getUserId()));
        note.setHeading(noteParam.getHeading());
        note.setNoteDate(noteParam.getNoteDate());
        noteRepository.save(note);
        return note;
    }

    public List<Note> getNoteListByUser(User user){

        return new ArrayList<Note>();
    }

}
