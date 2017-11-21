package com.wa.controllers;

import com.wa.domain.Note;
import com.wa.domain.User;
import com.wa.services.NoteService;
import com.wa.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
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

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody User userParam) {
        userService.saveOrUpdate(userParam);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/addNote", method = RequestMethod.POST)
    public ResponseEntity<?> addNote(@RequestBody Note noteParam) {
        noteService.saveOrUpdate(noteParam);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/getNoteList/{userId}", method = RequestMethod.GET)
    public ResponseEntity<?> getNoteLOst(@PathVariable int userId) {

        List<Note> noteList = noteService.getNoteListByUserId(new Long(userId));
        return new ResponseEntity<>(noteList, HttpStatus.CREATED);
    }



}
