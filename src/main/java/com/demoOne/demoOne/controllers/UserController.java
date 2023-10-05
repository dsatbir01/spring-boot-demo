package com.demoOne.demoOne.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demoOne.demoOne.entities.User;
import com.demoOne.demoOne.services.UserService;

@Controller
@ResponseBody
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/users")
    public ResponseEntity<Iterable<User>> getUsers() {
        Iterable<User> list = this.userService.getAllUsers();
        return ResponseEntity.of(Optional.of(list));
    }

    @RequestMapping("/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") int id) {
        User user = this.userService.getUserById(id);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(user));
    }

    @PostMapping("users")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        try {
            User result = this.userService.addUser(user);
            return ResponseEntity.of(Optional.of(result));

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("user/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable("id") int id) {
        try {
            User result = this.userService.updateUser(user, id);
            return ResponseEntity.of(Optional.of(result));

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") int id) {
        try {
            this.userService.deleteUser(id);
            return ResponseEntity.of(Optional.of("User deleted successfully."));

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
