package com.agency04.sbss.pizza.controller;

import com.agency04.sbss.pizza.model.Customer;
import com.agency04.sbss.pizza.service.CustomerServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    final CustomerServiceImpl customerService;

    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{username}")
    public String getCustomer(@PathVariable("username") String userName){
        Customer customer = customerService.getCustomer(userName);

        if(customer != null) {
            return customer.toString();
        }
        else {
            return "Customer " + userName + " does not exist!";
        }
    }

    /*
    curl -i --header "Content-Type: application/json" --request POST --data "{\"userName\":\"Kate\",\"address\":\"mejasi\",\"phoneNumber\":123456}" http://localhost:8080/api/customer
    */
    @PostMapping("")
    public void addCustomer(@RequestBody Customer customer) {
        if (customerService.customerExists(customer.getUserName())) {
            updateCustomer(customer);
        }
        customerService.addCustomer(customer);
    }

    @PutMapping("")
    public void updateCustomer(@RequestBody Customer customer) {
        customerService.updateCustomer(customer);
    }

    @DeleteMapping("/{username}")
    public void deleteCustomer(@PathVariable("username") String userName){
        customerService.deleteCustomer(userName);
    }
}
