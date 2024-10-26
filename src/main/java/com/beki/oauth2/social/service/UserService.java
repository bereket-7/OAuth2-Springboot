package com.beki.oauth2.social.service;

import com.beki.oauth2.social.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private List<User> users = new ArrayList<>();

    public UserService() {
        users.add(new User("1", "beki", "beki@example.com", "github"));
        users.add(new User("2", "beckam", "beckam@example.com", "google"));
        users.add(new User("3", "dani", "dani@example.com", "github"));
    }

    public List<User> getAllUsers() {
        return users;
    }

    public Optional<User> getUserById(String id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst();
    }

    public void addUser(User user) {
        users.add(user);
    }
}
