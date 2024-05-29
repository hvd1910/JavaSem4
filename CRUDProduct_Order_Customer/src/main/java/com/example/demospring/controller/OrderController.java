package com.example.demospring.controller;


import com.example.demospring.entity.Order;
import com.example.demospring.entity.Product;
import com.example.demospring.repository.OrderResponsitory;
import com.example.demospring.repository.ProductResponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderResponsitory orderRepository;

    @Autowired
    private ProductResponsitory productResponsitory;

    @GetMapping("/list")
    public String orderList(Model model) {
        List<Order> orderList = orderRepository.findAll();
        model.addAttribute("orders", orderList);
        return "listOrder";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        List<Product> allProducts = productResponsitory.findAll();
        model.addAttribute("allProducts", allProducts);
        model.addAttribute("order", new Order());
        return "addOrder";
    }

    @PostMapping("/add")
    public String addOrder(@ModelAttribute("order") Order order) {
        orderRepository.save(order);
        return "redirect:/orders/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        if (orderOptional.isPresent()) {
            model.addAttribute("order", orderOptional.get());
            return "addOrder";
        } else {
            return "redirect:/orders/list";
        }
    }

    @PostMapping("/edit/{id}")
    public String updateOrder(@PathVariable("id") Long id, @ModelAttribute("order") Order order) {
        order.setId(id);
        orderRepository.save(order);
        return "redirect:/orders/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteOrder(@PathVariable("id") Long id) {
        orderRepository.deleteById(id);
        return "redirect:/orders/list";
    }
}
