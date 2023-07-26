package com.example.demo.repositories;

import java.util.Optional;
import com.example.demo.entities.User;

public interface IUserRepository {
    User save(User user); 
    Optional<User> findById(Long id);
}
