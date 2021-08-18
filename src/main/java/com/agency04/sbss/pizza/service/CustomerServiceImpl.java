package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.exception.CustomerAlreadyExistsException;
import com.agency04.sbss.pizza.exception.CustomerNotFoundException;
import com.agency04.sbss.pizza.model.Customer;
import com.agency04.sbss.pizza.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer getCustomer(String userName) throws CustomerNotFoundException {
        Customer customer = customerRepository.findById(userName).orElseThrow(()-> new CustomerNotFoundException(userName));
        return customer;
    }

    @Override
    public Customer addCustomer(Customer customer) {
        if(customerRepository.existsById(customer.getUserName())){
            throw new CustomerAlreadyExistsException(customer.getUserName());
        }
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(String userName, Customer customer) {
        if(!customerRepository.existsById(userName)){
            throw new CustomerNotFoundException(userName);
        }
        Customer customer1 = customerRepository.getOne(userName);
        customer1.setCustomerDetails(customer.getCustomerDetails());
        return customerRepository.save(customer1);
    }

    @Override
    public Map<String, Boolean> deleteCustomer(String userName) throws CustomerNotFoundException {
        Customer customer = customerRepository.findById(userName).orElseThrow(()-> new CustomerNotFoundException(userName));
        customerRepository.delete(customer);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", true);
        return response;
    }

    @Override
    public List<Customer> customerList() {
        return customerRepository.findAll();
    }
}
