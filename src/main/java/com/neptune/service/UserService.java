package com.neptune.service;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neptune.model.User;
import com.neptune.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User addUser(User user) {
        user.setId(UUID.randomUUID().toString().split("-")[0]);
        return repo.save(user);
    }

    public List<User> findAllUsers() {
        return repo.findAll();
    }

    public User getUserByID(String id) {
        return repo.findById(id).orElse(null);
    }

    public User updateUser(User user) {
        User existingUser = repo.findById(user.getId()).orElse(null);
        if (existingUser != null) {
            existingUser.setName(user.getName());
            return repo.save(existingUser);
        }
        return null;
    }

    public String deleteUser(String id) {
        repo.deleteById(id);
        return id + " Deleted";
    }
}
