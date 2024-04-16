package org.example.steampowered.controller;

import java.util.concurrent.ExecutionException;

import org.example.steampowered.pojo.User;
import org.example.steampowered.service.UserDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
    
    @Autowired
    private UserDbService userDbService;

    @PostMapping("/users")
    public String saveUser(@RequestBody User user) throws InterruptedException, ExecutionException {
        return userDbService.saveUser(user);
    }
}
