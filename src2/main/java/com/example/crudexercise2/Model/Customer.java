package com.example.crudexercise2.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
//Customers Class : ID , Username , Balance
public class Customer {
    private String id;
    private String username;
    private double balance;
}
