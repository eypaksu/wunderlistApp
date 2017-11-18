package com.wa.services;


import com.wa.domain.User;

import java.util.List;

/**
 * Created by jt on 1/10/17.
 */
public interface UserService {

    List<User> listAll();

    User getById(Long id);

    User saveOrUpdate(User user);

    void delete(Long id);

}
