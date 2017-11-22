package com.wa.service;

import com.wa.domain.Note;
import com.wa.domain.User;
import com.wa.services.NoteServiceImpl;
import com.wa.services.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class NoteServiceTest {

    @Autowired
    private NoteServiceImpl noteServiceImpl;

    public static final String NOTE = "notoe 1";
    public static final String HEADING = "note";
    public static final Long USER_ID = Long.valueOf(1);
    public static final String USERNAME = "Eyup";
    public static final String PASS= "12345";

    User user;
    Note noteParam;
    Note note;

    @Before
    public void setUp(){
        user = new User();
        user.setUserId(USER_ID);
        user.setUsername(USERNAME);
        user.setPassword(PASS);

        UserService mockUserService = Mockito.mock(UserService.class);
        when(mockUserService.findById(USER_ID)).thenReturn(user);

        noteParam = new Note();
        noteParam.setNote(NOTE);
        noteParam.setHeading(HEADING);
        noteParam.setUser(mockUserService.findById(USER_ID));

        NoteServiceImpl mockNoteService = Mockito.mock(NoteServiceImpl.class);
        when(mockNoteService.getUser(anyLong())).thenReturn(user);

    }

    @Test
    public void createToSaveNoteTest(){
        note = noteServiceImpl.createNoteToSave(noteParam);
        Assert.assertEquals(NOTE, note.getNote());
        Assert.assertEquals(HEADING, note.getHeading());
    }


}
