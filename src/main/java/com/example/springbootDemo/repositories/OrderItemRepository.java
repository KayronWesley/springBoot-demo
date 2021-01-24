package com.example.springbootDemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootDemo.entities.Category;
import com.example.springbootDemo.entities.Order;
import com.example.springbootDemo.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
