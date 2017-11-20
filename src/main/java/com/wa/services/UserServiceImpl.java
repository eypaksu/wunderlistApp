package com.wa.services;

import com.wa.domain.User;
import com.wa.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> listAll() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add); //fun with Java 8
        return users;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public User saveOrUpdate(User userParam) {
        User user = new User();
        user.setUserName(userParam.getUserName());
        user.setPassword(userParam.getPassword());
        userRepository.save(user);
        return user;
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(id);

    }

}
