package com.agency04.sbss.pizza.controller;

import com.agency04.sbss.pizza.exception.CustomerAlreadyExistsException;
import com.agency04.sbss.pizza.exception.CustomerNotFoundException;
import com.agency04.sbss.pizza.model.Customer;
import com.agency04.sbss.pizza.repository.CustomerRepository;
import com.agency04.sbss.pizza.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerRepository customerRepository;
    private final CustomerService customerService;

    public CustomerController(CustomerRepository customerRepository, CustomerService customerService) {
        this.customerRepository = customerRepository;
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/{username}")
    ResponseEntity<Customer> getCustomerByUsername(@PathVariable("username") String userName) throws CustomerNotFoundException {
        Customer customer = customerService.getCustomer(userName).orElseThrow(() -> new CustomerNotFoundException(userName));
        return ResponseEntity.ok().body(customer);
    }

    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        Optional<Customer> customer1 = customerRepository.findById(customer.getUserName());
        if (customer1.isPresent()) {
            {
                throw new CustomerAlreadyExistsException(customer.getUserName());
            }
        }
        return ResponseEntity.ok(customerRepository.save(customer));
    }

    @PutMapping("/{username}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("username") String userName, @RequestBody Customer
            customerDetails) throws CustomerNotFoundException {
        Customer customer = customerRepository.findById(userName).orElseThrow(() -> new CustomerNotFoundException(userName));
        customer.setCustomerDetails(customerDetails.getCustomerDetails());
        final Customer updatedCustomer = customerRepository.save(customer);
        return ResponseEntity.ok(updatedCustomer);
    }

    @DeleteMapping("/{username}")
    public Map<String, Boolean> deleteCustomer(@PathVariable("username") String userName) throws
            CustomerNotFoundException {
        Customer customer = customerRepository.findById(userName).orElseThrow(() -> new CustomerNotFoundException(userName));
        customerRepository.delete(customer);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
