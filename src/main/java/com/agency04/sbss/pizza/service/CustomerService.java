package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.Customer;

import java.util.Optional;

public interface CustomerService {

    boolean customerExists(String userName);
    Optional<Customer> getCustomer(String userName);
    void addCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(Customer customer);
}
