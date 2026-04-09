package com.prono.cdm2026.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prono.cdm2026.model.Groupe;
import com.prono.cdm2026.model.User;

import com.prono.cdm2026.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }
    public User save(User user){
        return userRepository.save(user);
    }
     public User findById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    
}
