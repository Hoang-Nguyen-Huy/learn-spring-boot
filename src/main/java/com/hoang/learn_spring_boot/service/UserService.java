package com.hoang.learn_spring_boot.service;

import com.hoang.learn_spring_boot.dto.UserCreateDTO;
import com.hoang.learn_spring_boot.dto.UserUpdateDTO;
import com.hoang.learn_spring_boot.entity.User;
import com.hoang.learn_spring_boot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(UserCreateDTO dto) {
        User user = new User();
        user.setUserName(dto.getUserName());
        user.setPassword(dto.getPassword());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setDob(dto.getDob());

        return userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserById(UUID userId) {
        return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User updateUser(UUID userId, UserUpdateDTO dto) {
        User updateUser = getUserById(userId);
        updateUser.setPassword(dto.getPassword());
        updateUser.setFirstName(dto.getFirstName());
        updateUser.setLastName(dto.getLastName());
        updateUser.setDob(dto.getDob());
        return userRepository.save(updateUser);
    }

    public void deleteUser(UUID userId) {
        userRepository.delete(getUserById(userId));
    }
}
