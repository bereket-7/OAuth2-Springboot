package com.beki.oauth2.social;

import com.beki.oauth2.social.model.User;
import com.beki.oauth2.social.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserServiceTest {
    private UserService userService;

    @BeforeEach
    public void setUp() {
        userService = new UserService();
    }

    @Test
    public void testGetAllUsers() {
        assertEquals(3, userService.getAllUsers().size(), "Initial size of user list should be 3");
    }

    @Test
    public void testGetUserById_UserExists() {
        Optional<User> user = userService.getUserById("1");
        assertTrue(user.isPresent(), "User with ID 1 should be present");
        assertEquals("beki", user.get().getUsername(), "User with ID 1 should have username 'beki'");
    }

    @Test
    public void testGetUserById_UserDoesNotExist() {
        Optional<User> user = userService.getUserById("99");
        assertTrue(user.isEmpty(), "User with ID 99 should not be present");
    }

    @Test
    public void testAddUser() {
        User newUser = new User("4", "alex", "alex@example.com", "google");
        userService.addUser(newUser);

        assertEquals(4, userService.getAllUsers().size(), "Size of user list should be 4 after adding a user");
        Optional<User> retrievedUser = userService.getUserById("4");
        assertTrue(retrievedUser.isPresent(), "New user with ID 4 should be present");
        assertEquals("alex", retrievedUser.get().getUsername(), "New user should have username 'alex'");
    }
}
