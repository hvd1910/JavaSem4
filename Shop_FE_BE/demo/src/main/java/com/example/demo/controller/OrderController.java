package com.example.demo.controller;


import com.example.demo.dtos.OrderDTO;
import com.example.demo.model.Customer;
import com.example.demo.model.Order;
import com.example.demo.model.Product;
import com.example.demo.respository.CustomerRespository;
import com.example.demo.respository.OrderRespository;
import com.example.demo.respository.ProductRespository;
import jakarta.validation.Valid;
import lombok.NoArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins  = "http://localhost:3000/", maxAge = 3600)
@RestController
@RequestMapping("/orders")
@NoArgsConstructor
public class OrderController {

    @Autowired
    private OrderRespository orderRespository;
    @Autowired
    private CustomerRespository customerRespository;
    @Autowired
    private ProductRespository productRespository;

    @PostMapping("")
    public ResponseEntity<?> createOrder(
            @Valid @RequestBody OrderDTO orderDTO,
            BindingResult result
    ) throws Exception {
        if (result.hasErrors()) {
            List<String> errorMessages = result.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)
                    .toList();
            return ResponseEntity.badRequest().body(errorMessages);
        }

        try {
            Optional<Customer> customerOptional  = customerRespository.findByEmail(orderDTO.getEmail());
            Optional<Product> productOptional = productRespository.findById(orderDTO.getProductId());
            if(customerOptional.isPresent() && productOptional.isPresent()) {
                Order order = new Order();
                order.setCustomer(customerOptional.get());
                order.setProduct(productOptional.get());
                order.setOrderDate(new Date());
                order.setPrice(orderDTO.getPrice());
                order.setStatus("pending");
                orderRespository.save(order);  // Save the order to the database
                return ResponseEntity.ok(order);
            }
            else {
                return ResponseEntity.badRequest().body("Customer or Product not found.");
            }
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Đã có lỗi xẩy ra.");
        }









    }


    @GetMapping("/{orderId}")
    public ResponseEntity<?> getOrderById(@PathVariable("orderId") Long orderId) {
        Optional<Order> order = orderRespository.findById(orderId);
        if(order.isPresent())  {
            return ResponseEntity.ok(order);

        }else {
            return ResponseEntity.ok("Đơn hàng không tồn tại.");

        }

    }



    @GetMapping("/customer/{customerId}")
    public ResponseEntity<?> getOrderByUser(@PathVariable("customerId") Long customerId) {
        List<Order> orders = orderRespository.findByCustomerId(customerId);
        return ResponseEntity.ok(orders);
    }



    @PutMapping("/{orderId}")
    public ResponseEntity<?> updateOrder(@PathVariable("orderId") Long orderId,
                                         @RequestParam(defaultValue = "") String status) {
        Optional<Order> order = orderRespository.findById(orderId);
        if(order.isPresent()) {
            order.get().setStatus(status);
            Order orderSave = orderRespository.save(order.get());
            return ResponseEntity.ok(orderSave);

        }
        return ResponseEntity.ok("Đơn hàng không tồn tại.");

    }

}
