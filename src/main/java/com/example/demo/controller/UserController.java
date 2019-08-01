package com.example.demo.controller;

import com.example.demo.dao.UserMapper;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/user")
    public List<User> findAll() {
        List<User> user = userMapper.findAll();
        return user;
    }

    @GetMapping("/user/{userId}")
    public User findById(@PathVariable long userId) {
        User user = userMapper.findUserById(userId);
        return user;
    }

    @PostMapping("/user")
    public void insertUser(@RequestBody User user) {
        user = new User();
        user.setId(30);
        user.setName("杨洁");
        userMapper.insertUser(user);
    }

    @PutMapping("/user/{userId}")
    public void updateUser(@RequestBody User user,@PathVariable int userId) {
        user.setId(userId);
        user.setName("yangjie12345");
        userMapper.updateUser(user);
    }

    @DeleteMapping("/user/{userId}")
    public void deleteById(@PathVariable long userId) {
        userMapper.delete(userId);
    }
}