package com.wa.services;


import com.wa.domain.User;

public interface UserService {

    User findById(Long id);

    void saveOrUpdate(User user);

}
