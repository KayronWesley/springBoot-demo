package com.example.springbootDemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootDemo.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
