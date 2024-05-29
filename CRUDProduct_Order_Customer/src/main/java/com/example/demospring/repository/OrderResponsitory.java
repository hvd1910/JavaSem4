package com.example.demospring.repository;

import com.example.demospring.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderResponsitory extends JpaRepository<Order, Long> {
}
