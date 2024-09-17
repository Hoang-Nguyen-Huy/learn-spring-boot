package com.hoang.learn_spring_boot.repository;

import com.hoang.learn_spring_boot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
