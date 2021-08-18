package com.agency04.sbss.pizza;

import com.agency04.sbss.pizza.model.*;
import com.agency04.sbss.pizza.repository.CustomerRepository;
import com.agency04.sbss.pizza.repository.PizzaRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;
import java.util.*;

@SpringBootApplication
public class PizzaApp implements ApplicationRunner {

    public static void main(String[] args) {

        SpringApplication.run(PizzaApp.class, args);
    }

    private final CustomerRepository customerRepository;
    private final PizzaRepository pizzaRepository;

    public PizzaApp(CustomerRepository customerRepository, PizzaRepository pizzaRepository) {
        this.customerRepository = customerRepository;
        this.pizzaRepository = pizzaRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Customer customer = new Customer("kate");
        CustomerDetails customerDetails = new CustomerDetails("Katarina", "Mandalinic", "+385");
        Instant subDate = Instant.now();

        Pizza pizzaMargherita = new Pizza();
        pizzaMargherita.setName("Margherita");
        pizzaMargherita.setIngredients(Set.of(PizzaIngredient.TOMATO_SAUCE, PizzaIngredient.MOZZARELLA));

        Pizza pizzaFrutti = new Pizza();
        pizzaFrutti.setName("Frutti di Mare");
        pizzaFrutti.setIngredients(Set.of(PizzaIngredient.TOMATO_SAUCE, PizzaIngredient.MOZZARELLA, PizzaIngredient.SEAFOOD));

        pizzaRepository.save(pizzaMargherita);
        pizzaRepository.save(pizzaFrutti);

        customer.setCustomerDetails(customerDetails);
        customerRepository.save(customer);
    }
}
