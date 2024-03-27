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

    public List<User> getUsers() {
        return userRepository.users();
    }

    public void addUser(User user) {
        userRepository.addUser(user);
    }

    public User getUser(int index) {
        return userRepository.getUser(index);
    }
    
}
