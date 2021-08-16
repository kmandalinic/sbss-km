package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.Customer;
import com.agency04.sbss.pizza.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public boolean customerExists(String userName) {
        return customerRepository.existsById(userName);
    }

    @Override
    public Optional<Customer> getCustomer(String userName) {
        return customerRepository.findById(userName);
    }

    @Override
    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Customer customer) {
        customerRepository.delete(customer);
    }
}
