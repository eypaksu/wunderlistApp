package com.wa.services;

import com.wa.domain.Note;
import com.wa.domain.User;
import com.wa.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private UserService userService;

    @Override
    public void saveOrUpdate(Note noteParam) {
        noteRepository.save(createNoteToSave(noteParam));
    }

    @Override
    public List<Note> getNoteListByUserId(Long userId) {
        User user = userService.findById(userId);
        return noteRepository.findByUser(user);
    }

    public Note createNoteToSave(Note noteParam) {
        Note note = new Note();
        note.setUser(getUser(noteParam.getUser().getUserId()));
        note.setHeading(noteParam.getHeading());
        note.setNote(noteParam.getNote());
        note.setNoteDate(noteParam.getNoteDate());

        return note;
    }

    public User getUser(Long userId){
        return userService.findById(userId);
    }


}
