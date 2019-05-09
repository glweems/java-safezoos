package com.lambdaschool.zoo.repository;

import com.lambdaschool.zoo.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>
{
    User findByUsername(String username);
}
