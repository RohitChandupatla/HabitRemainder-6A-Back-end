package com.northwest.habit_reminder.controller;

import com.northwest.habit_reminder.entities.User;
import com.northwest.habit_reminder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user/signup")
    public ResponseEntity signup(@RequestBody User user) {
        try {
            userRepository.save(user);
            return new ResponseEntity("Added " + user.getFirstName(), HttpStatus.OK);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/user/login")
    public ResponseEntity login(@RequestBody User user) {
        List<User> userList = userRepository.findByPassword(user.getPassword());
        for (User u: userList){
            if (u.getEmail().equals(user.getEmail())) {
                return new ResponseEntity("Welcome " + user.getFirstName(), HttpStatus.OK);
            }
        }
        return new ResponseEntity("User not found", HttpStatus.NOT_FOUND);
    }
}
