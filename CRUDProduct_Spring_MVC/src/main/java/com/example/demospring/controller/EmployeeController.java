package com.example.demospring.controller;

import com.example.demospring.entity.Employee;
import com.example.demospring.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String listEmployees(Model model) {
        List<Employee> employees = employeeRepository.findAll();
        model.addAttribute("employees", employees);
        return "list";
    }

    @GetMapping("/edit/{id}")
    public String editEmployee(@PathVariable Long id, Model model) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee == null) {
            return "redirect:/";
        }
        model.addAttribute("employee", employee);
        return "edit";
    }

    @PostMapping("/update")
    public String updateEmployee(
            @ModelAttribute Employee updatedEmployee,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            // Handle errors if necessary
            return "edit";
        }

        employeeRepository.save(updatedEmployee);
        return "redirect:/";
    }

    @PostMapping("/add")
    public String addEmployee (
            @RequestParam String fullName,
            @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date birthday,
            @RequestParam String address,
            @RequestParam String position,
            @RequestParam String department) {

        Employee newEmployee = new Employee(fullName, birthday, address, position, department);
        employeeRepository.save(newEmployee);
        return "redirect:/";
    }


    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeRepository.deleteById(id);
        return "redirect:/";
    }
}
