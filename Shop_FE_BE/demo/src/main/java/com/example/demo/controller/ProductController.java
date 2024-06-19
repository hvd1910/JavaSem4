package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.respository.ProductRespository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins  = "http://localhost:3000/", maxAge = 3600)
@RestController
@RequestMapping("/products")
@NoArgsConstructor
public class ProductController {
    @Autowired
    private ProductRespository productRespository;

    @GetMapping("")
    public ResponseEntity<?> getProductAll() {
        List<Product> products = productRespository.findAll();
        return  ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable("id") Long productId) {
        Optional<Product> product = productRespository.findById(productId);
        if(product.isPresent()) {
            return ResponseEntity.ok(product);
        }
        else {
            return  ResponseEntity.ok("Không tìm thấy sản phẩm");
        }
    }




}
