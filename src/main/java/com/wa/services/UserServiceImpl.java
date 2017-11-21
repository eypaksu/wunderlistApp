package com.wa.services;

import com.wa.domain.User;
import com.wa.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Override
    public User findById(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public void saveOrUpdate(User userParam) {
        userRepository.save(createUserObject(userParam));
    }

    public User createUserObject(User userParam){
        User user = new User();
        user.setUsername(userParam.getUsername());
        user.setPassword(getPasswordEncoder().encode(userParam.getPassword()));

        return user;
    }


}
