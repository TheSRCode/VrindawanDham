package com.teerth.vrindawandham.repository;

import com.teerth.vrindawandham.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);  // Optional method to fetch by username
}
