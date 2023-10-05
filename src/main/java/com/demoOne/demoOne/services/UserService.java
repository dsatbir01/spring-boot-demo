package com.demoOne.demoOne.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demoOne.demoOne.dao.UserRepository;
import com.demoOne.demoOne.entities.User;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // get All User
    public Iterable<User> getAllUsers() {
        Iterable<User> list = this.userRepository.findAll();
        return list;
    }

    // get user by id
    public User getUserById(int id) {
        return this.userRepository.findById(id);
    }

    public User addUser(User u) {
        User result = this.userRepository.save(u);
        return result;
    }

    public void deleteUser(int id) {
        this.userRepository.deleteById(id);
    }

    public User updateUser(User u, int id) {
        u.setId(id);
        User result = this.userRepository.save(u);
        return result;
    }
}
