package com.wa.controllers;

import com.wa.domain.Note;
import com.wa.domain.User;
import com.wa.services.NoteService;
import com.wa.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "/getInfo", method = RequestMethod.GET)
    public String redirToList() {
        return "hello ";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody User userParam) {
        User user = new User();
        user.setUserName(userParam.getUserName());
        user.setPassword(userParam.getPassword());
        userService.saveOrUpdate(user);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/addNote", method = RequestMethod.POST)
    public ResponseEntity<?> addNote(@RequestBody Note noteParam) {
        Note note = new Note();
        note.setHeading(noteParam.getHeading());
        note.setNoteDate(noteParam.getNoteDate());
        note.setUser(userService.findById(noteParam.getUser().getUserId()));

        noteService.saveOrUpdate(note);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

//    @RequestMapping({"/product/list", "/product"})
//    public String listProducts(Model model){
//        model.addAttribute("products", userService.listAll());
//        return "product/list";
//    }
//
//    @RequestMapping("/product/show/{id}")
//    public String getProduct(@PathVariable String id, Model model){
//        model.addAttribute("product", userService.getById(Long.valueOf(id)));
//        return "product/show";
//    }
//
//    @RequestMapping("/product/delete/{id}")
//    public String delete(@PathVariable String id){
//        userService.delete(Long.valueOf(id));
//        return "redirect:/product/list";
//    }
}
