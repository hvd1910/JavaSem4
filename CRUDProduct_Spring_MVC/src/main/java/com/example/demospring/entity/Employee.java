package com.example.demospring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    private String address;

    private String position;

    private String department;

    // Constructors, getters, and setters


    public Employee(String fullName, Long id, Date birthday, String address, String position, String department) {
        this.fullName = fullName;
        this.id = id;
        this.birthday = birthday;
        this.address = address;
        this.position = position;
        this.department = department;
    }

    public Employee() {}

    public Employee(String fullName, Date birthday, String address, String position, String department) {
        this.fullName = fullName;
        this.birthday = birthday;
        this.address = address;
        this.position = position;
        this.department = department;

    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getAddress() {
        return address;
    }

    public String getPosition() {
        return position;
    }

    public String getDepartment() {
        return department;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
