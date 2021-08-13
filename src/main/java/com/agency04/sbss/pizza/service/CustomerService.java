package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.Customer;

public interface CustomerService {

    boolean customerExists(String userName);
    Customer getCustomer(String userName);
    void addCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(String userName);
}
