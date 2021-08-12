package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.Customer;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CustomerServiceImpl implements  CustomerService{

    final Map<String, Customer> customerMap = new HashMap<>();

    @Override
    public boolean customerExists(String userName) {
        return customerMap.containsKey(userName);
    }

    @Override
    public Customer getCustomer(String userName) {
        return customerMap.get(userName);
    }
    @Override
    public void addCustomer(Customer customer) {
        customerMap.put(customer.getUserName(), customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerMap.put(customer.getUserName(), customer);
    }

    @Override
    public void deleteCustomer(String userName) {
        customerMap.remove(userName);
    }
}
