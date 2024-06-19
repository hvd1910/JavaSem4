package com.example.demo.respository;

import com.example.demo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRespository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByEmail(String email);

}
