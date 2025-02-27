package com.adk.user.service.controller;

import com.adk.user.service.entities.User;
import com.adk.user.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ankushk
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
         User user1=userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId)
    {
        User user=userService.getUser(userId);
        return ResponseEntity.ok(user);
    }

    @GetMapping()
    public ResponseEntity<List<User>> getAllUser()
    {
        List<User> userList = userService.getAllUser();
        return ResponseEntity.ok(userList);
    }



            }

