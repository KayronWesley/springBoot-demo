package com.example.springbootDemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootDemo.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
