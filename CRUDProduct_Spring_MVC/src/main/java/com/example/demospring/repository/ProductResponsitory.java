package com.example.demospring.repository;

import com.example.demospring.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductResponsitory extends JpaRepository<Product, Long> {
}
