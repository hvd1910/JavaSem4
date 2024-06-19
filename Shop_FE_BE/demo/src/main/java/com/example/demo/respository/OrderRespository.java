package com.example.demo.respository;

import com.example.demo.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRespository extends JpaRepository<Order, Long> {

    List<Order> findByCustomerId(Long customerId);

}
