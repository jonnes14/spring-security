package com.jonnes.spring_security.service;

import com.jonnes.spring_security.dao.UserRepo;
import com.jonnes.spring_security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);

    public User saveUser(User user){
        user.setPassword(encoder.encode(user.getPassword()));
       return repo.save(user);
    }

}
