package com.agency04.sbss.pizza.controller;

import com.agency04.sbss.pizza.model.Customer;
import com.agency04.sbss.pizza.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.customerList();
    }

    @GetMapping("/{username}")
    public ResponseEntity<Customer> getCustomerByUsername(@PathVariable("username") String userName) {
        return ResponseEntity.ok().body(customerService.getCustomer(userName));
    }

    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.addCustomer(customer));
    }

    @PutMapping("/{username}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("username") String userName, @RequestBody Customer
            customerBody) {
        return ResponseEntity.ok(customerService.updateCustomer(userName, customerBody));
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<Map<String, Boolean>> deleteCustomer(@PathVariable("username") String userName) {
        return ResponseEntity.ok(customerService.deleteCustomer(userName));
    }
}
