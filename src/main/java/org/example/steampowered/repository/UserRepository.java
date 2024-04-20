package org.example.steampowered.repository;

import org.example.steampowered.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    User user = new User();      

    public User getUser() {
        return this.user;
    }    

    public void nullUser(){
        this.user = null;
    }
}
