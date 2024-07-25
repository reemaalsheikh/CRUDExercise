package com.example.crudexercise2.Controller;

import com.example.crudexercise2.Api.ApiResponse;
import com.example.crudexercise2.Model.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    ArrayList<Customer> customers = new ArrayList<>();

    //    Endpoints :
//    Get all the customers
    @GetMapping("/get")
    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    //    Add new customers
    @PostMapping("/add")
    public ApiResponse addCustomer(@RequestBody Customer customer) {
        customers.add(customer);
        return new ApiResponse("Successfully added customer!");
    }

    //    Update customers
    @PutMapping("/update/{index}")
    public ApiResponse updateCustomer(@PathVariable int index, @RequestBody Customer customer) {
        customers.set(index, customer);
        return new ApiResponse("Successfully updated customer!");
    }

    //    Delete customers
    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteCustomer(@PathVariable int index) {
        customers.remove(index);
        return new ApiResponse("Successfully deleted customer!");
    }

    //    Deposit money to customer
    @PostMapping("/deposit/{id}")
    public ApiResponse deposit(@PathVariable int id, @RequestParam double amount) {
        Customer customer = customers.get(id);
            customer.setBalance(customer.getBalance() + amount);
        return new ApiResponse("Successfully deposited customer!");

    }
//    Withdraw money from customers

    @PostMapping("/withdraw/{id}")
    public ApiResponse withdraw(@PathVariable int id, @RequestParam double amount) {
        Customer customer = customers.get(id);
        if (customer.getBalance() >= amount) {
            customer.setBalance(customer.getBalance() - amount);
            return new ApiResponse("Successfully withdrawn customer!");
        }
        return new ApiResponse("Not enough balance!");
    }



}