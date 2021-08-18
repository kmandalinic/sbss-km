package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.Customer;
import java.util.List;
import java.util.Map;

public interface CustomerService {

    Customer getCustomer(String userName);
    Customer addCustomer(Customer customer);
    Customer updateCustomer(String userName, Customer customer);
    Map<String, Boolean> deleteCustomer(String userName);
    List<Customer> customerList();
}
