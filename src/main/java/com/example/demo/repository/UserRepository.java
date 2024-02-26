package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modal.MyUser;

public interface UserRepository extends JpaRepository<MyUser, Long> {
    MyUser findByUsername(String username);
}