package com.wa.controllers;

import com.wa.domain.Note;
import com.wa.domain.User;
import com.wa.services.NoteService;
import com.wa.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WunderListAppController {
    private UserService userService;

    private NoteService noteService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void getNoteService(NoteService noteService) {
        this.noteService = noteService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String redirToList() {
        return "welcome wunderlistApp ";
    }

    @RequestMapping(value = "/api/addUser", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody User userParam) {
        userService.saveOrUpdate(userParam);
        return new ResponseEntity<String>("User created successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/api/addNote", method = RequestMethod.POST)
    public ResponseEntity<?> addNote(@RequestBody Note noteParam) {
        noteService.saveOrUpdate(noteParam);
        return new ResponseEntity<String>("Note added successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/getNoteList/{userId}", method = RequestMethod.GET)
    public ResponseEntity<?> getNoteLOst(@PathVariable int userId) {

        List<Note> noteList = noteService.getNoteListByUserId(new Long(userId));
        return new ResponseEntity<>(noteList, HttpStatus.CREATED);
    }


}
