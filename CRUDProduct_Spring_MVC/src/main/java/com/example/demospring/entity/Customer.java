package com.example.demospring.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;


    private  String email;


    private  String phone_number;


    private String address;


    // Constructors, getters, and setters




    public Customer() {}

    public Customer(Long id, String fullName, Date birthday, String email, String phone_number, String address) {
        this.id = id;
        this.fullName = fullName;
        this.birthday = birthday;
        this.email = email;
        this.phone_number = phone_number;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }




}
