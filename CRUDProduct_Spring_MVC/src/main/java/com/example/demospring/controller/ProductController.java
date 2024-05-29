package com.example.demospring.controller;

import com.example.demospring.entity.Product;
import com.example.demospring.repository.CustomerRepository;
import com.example.demospring.repository.ProductResponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductResponsitory productResponsitory;


    @GetMapping("/list")
    public String productList(Model model) {
        List<Product> productList = productResponsitory.findAll();
        model.addAttribute("products", productList);
        return "listProduct";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("product", new Product());
        return "addProduct";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute("product") Product product) {
        productResponsitory.save(product);
        return "redirect:/products/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Optional<Product> productOptional = productResponsitory.findById(id);
        if (productOptional.isPresent()) {
            model.addAttribute("product", productOptional.get());
            return "addProduct";
        } else {
            return "redirect:/products/list";
        }
    }

    @PostMapping("/edit/{id}")
    public String updateProduct(@PathVariable("id") Long id, @ModelAttribute("product") Product product) {
        product.setId(id);
        productResponsitory.save(product);
        return "redirect:/products/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productResponsitory.deleteById(id);
        return "redirect:/products/list";
    }


}
