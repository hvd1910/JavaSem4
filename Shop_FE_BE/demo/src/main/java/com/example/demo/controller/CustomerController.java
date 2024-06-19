package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.respository.CustomerRespository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins  = "http://localhost:3000/", maxAge = 3600)
@RestController
@RequestMapping("/customers")
@NoArgsConstructor
public class CustomerController {
    @Autowired
    private CustomerRespository customerRespository;


    @GetMapping("")
    public ResponseEntity<?> getCustomerAll() {
        List<Customer> customers = customerRespository.findAll();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable("id") Long id) {
        Optional<Customer> customer = customerRespository.findById(id);
        if (customer.isPresent()) {
            return ResponseEntity.ok(customer);
        }else {
            ResponseEntity.ok(" Người dùng này không tồn tại");
        }

        return null;
    }
}
