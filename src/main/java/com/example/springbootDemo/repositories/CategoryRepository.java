package com.example.springbootDemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootDemo.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
