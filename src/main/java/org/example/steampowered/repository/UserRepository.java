package org.example.steampowered.repository;

import java.util.ArrayList;
import java.util.List;

import org.example.steampowered.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    private List<User> users = new ArrayList<>();

    public List<User> users() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public User getUser(int index) {
        return users.get(index);
    }




    
}
