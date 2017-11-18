package com.wa.repositories;

import com.wa.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jt on 1/10/17.
 */
public interface UserRepository extends CrudRepository<User, Long> {
}
