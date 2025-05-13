package com.example.crud_demo.service;

import com.example.crud_demo.model.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    private final Map<Integer, User> userMap = new HashMap<>();
    private int currentId = 1;

    public User createUser(User user) {
        user.setId(currentId++);
        userMap.put(user.getId(), user);
        return user;
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(userMap.values());
    }

    public User getUserById(int id) {
        if (!userMap.containsKey(id)) {
            throw new NoSuchElementException("User not found");
        }
        return userMap.get(id);
    }

    public User updateUser(int id, User user) {
        if (!userMap.containsKey(id)) {
            throw new NoSuchElementException("User not found");
        }
        user.setId(id);
        userMap.put(id, user);
        return user;
    }

    public void deleteUser(int id) {
        if (!userMap.containsKey(id)) {
            throw new NoSuchElementException("User not found");
        }
        userMap.remove(id);
    }
}
