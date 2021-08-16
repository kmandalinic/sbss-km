package com.agency04.sbss.pizza;

import com.agency04.sbss.pizza.model.Customer;
import com.agency04.sbss.pizza.model.CustomerDetails;
import com.agency04.sbss.pizza.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class CustomerRunner implements CommandLineRunner {

    final CustomerRepository customerRepository;

    public CustomerRunner(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Customer customer = new Customer("Nike");
        CustomerDetails customerDetails = new CustomerDetails("Nikolina","Dapic","+3859");

        customer.setCustomerDetails(customerDetails);
        customerRepository.save(customer);

    }
}
