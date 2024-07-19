package org.example.bookap22.Service;

import org.example.bookap22.Entity.Order;
import org.example.bookap22.Repository.OrderRepository;
import org.example.bookap22.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> getOrdersByUserId(Long userId) {
        return orderRepository.getOrdersByUserId(userId);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public Order updateOrder(Long id, Order orderDetails) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id " + id));
        order.setBooks(orderDetails.getBooks());
        order.setUser(orderDetails.getUser());
        order.setOrderDate(orderDetails.getOrderDate());
        return orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id " + id));
        orderRepository.delete(order);
    }
}
