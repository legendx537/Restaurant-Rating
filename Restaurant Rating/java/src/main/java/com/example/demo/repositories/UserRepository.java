package com.example.demo.repositories;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import com.example.demo.entities.User;

public class UserRepository implements IUserRepository{
    
    private Map<Long , User> userMap;
    private Long autoIncrement=1L;

    public UserRepository(){
        this.userMap=new HashMap<Long , User>();
    }

    @Override
    public User save(User user) {
        // TODO Auto-generated method stub
        
        // Make a new user
        User u=new User( autoIncrement , user.getName());
        
        // put in map
        userMap.put( autoIncrement , u);

        // Increment the autoIncrement for next user to be registered
        autoIncrement++;

        return u;
    }

    @Override
    public Optional<User> findById(Long id) {
        // TODO Auto-generated method stub
        return Optional.ofNullable(userMap.get(id));
    }
    
}
