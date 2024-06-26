package com.example.demospring.controller;

import com.example.demospring.entity.Customer;
import com.example.demospring.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller

public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/")
    public String listEmployees(Model model) {
        List<Customer> employees = customerRepository.findAll();
        model.addAttribute("employees", employees);
        return "list";
    }

    @GetMapping("/edit/{id}")
    public String editEmployee(@PathVariable Long id, Model model) {
        Customer employee = customerRepository.findById(id).orElse(null);
        if (employee == null) {
            return "redirect:/";
        }
        model.addAttribute("employee", employee);
        return "edit";
    }

    @PostMapping("/update")
    public String updateEmployee(
            @ModelAttribute Customer updatedEmployee,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            // Handle errors if necessary
            return "edit";
        }

        customerRepository.save(updatedEmployee);
        return "redirect:/";
    }

    @PostMapping("/add")
    public String addEmployee (
            @RequestParam String fullName,
            @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date birthday,
            @RequestParam String email,
            @RequestParam String phone_number,
            @RequestParam String address
            ) {

        Customer newEmployee = new Customer();
        newEmployee.setFullName(fullName);
        newEmployee.setBirthday(birthday);
        newEmployee.setEmail(email);
        newEmployee.setPhone_number(phone_number);
        newEmployee.setAddress(address);
        customerRepository.save(newEmployee);
        return "redirect:/";
    }


    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        customerRepository.deleteById(id);
        return "redirect:/";
    }
}
