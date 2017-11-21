package com.wa.service;

import com.wa.domain.Note;
import com.wa.services.NoteServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class NoteServiceTest {

    @Autowired
    private NoteServiceImpl noteServiceImpl;

    public static final String NOTE = "";
    public static final String HEADING = "";



    @Test
    public void createToSaveNoteTest(){
//        Note noteParam = new Note();
//        noteParam.setNote(NOTE);
//        noteParam.setHeading(HEADING);
    }



//    LocalizationMappingRepository mockRepo = Mockito.mock(LocalizationMappingRepository.class);
//    when(mockRepo.findByAccountId("accountId")).thenReturn(new ArrayList<>(
//            Arrays.asList(
//            new LocalizationMapping("accountId", "TSN", "Time Since New"),
//                new LocalizationMapping("accountId", "CSN", "Cycles Since New"),
//                new LocalizationMapping("accountId", "SER", "Serial Number"),
//                new LocalizationMapping("accountId", "MPN", "Part Number")
//            )
//                    ));

}
