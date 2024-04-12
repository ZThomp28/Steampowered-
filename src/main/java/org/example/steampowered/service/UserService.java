package org.example.steampowered.service;

import java.util.List;

import org.example.steampowered.pojo.User;
import org.example.steampowered.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository = new UserRepository();

    public User getUser(){
        return userRepository.getUser();
    }

    public void nullUser(){
        userRepository.getUser().setProfileImage("");
        userRepository.getUser().setSteamID("");
        userRepository.getUser().setSteamUserName("");
    }
    
}
