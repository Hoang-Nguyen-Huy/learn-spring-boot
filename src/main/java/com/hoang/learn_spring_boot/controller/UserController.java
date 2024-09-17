package com.hoang.learn_spring_boot.controller;

import com.hoang.learn_spring_boot.dto.UserCreateDTO;
import com.hoang.learn_spring_boot.dto.UserUpdateDTO;
import com.hoang.learn_spring_boot.entity.User;
import com.hoang.learn_spring_boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody UserCreateDTO dto) {
        return userService.createUser(dto);
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") UUID userId) {
        return userService.getUserById(userId);
    }

    @PutMapping("/{userId}")
    public User updateUser(@PathVariable("userId") UUID userId, @RequestBody UserUpdateDTO dto) {
        return userService.updateUser(userId, dto);
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable("userId") UUID userId) {
        userService.deleteUser(userId);
        return "Delete successfully";
    }
}
