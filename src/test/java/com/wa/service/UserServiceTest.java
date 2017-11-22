package com.wa.service;


import com.wa.domain.User;
import com.wa.services.UserServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceTest {

    public static final String USERNAME = "Eyup";

    public static final String PASSWORD = "12345";

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Test
    public void saveUserTest() {

        User userAsParam = new User();

        userAsParam.setUsername(USERNAME);
        userAsParam.setPassword(PASSWORD);

        User userToSave = userServiceImpl.createUserObject(userAsParam);

        Assert.assertEquals(USERNAME, userToSave.getUsername());
        Assert.assertNotNull(userToSave.getPassword());
        Assert.assertNotEquals(PASSWORD,userToSave.getPassword());

    }

}
