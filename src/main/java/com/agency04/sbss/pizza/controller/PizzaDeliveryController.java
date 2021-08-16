package com.agency04.sbss.pizza.controller;

import com.agency04.sbss.pizza.exception.CustomerNotFoundException;
import com.agency04.sbss.pizza.exception.PizzaNotFoundException;
import com.agency04.sbss.pizza.form.DeliveryOrderForm;
import com.agency04.sbss.pizza.form.PizzaOrderForm;
import com.agency04.sbss.pizza.model.*;
import com.agency04.sbss.pizza.repository.CustomerRepository;
import com.agency04.sbss.pizza.repository.DeliveryRepository;
import com.agency04.sbss.pizza.repository.PizzaOrderRepository;
import com.agency04.sbss.pizza.repository.PizzaRepository;
import com.agency04.sbss.pizza.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/delivery")
public class PizzaDeliveryController {

    private final DeliveryRepository deliveryRepository;
    private final CustomerRepository customerRepository;
    private final PizzaOrderRepository pizzaOrderRepository;
    private final PizzaRepository pizzaRepository;

    public PizzaDeliveryController(DeliveryRepository deliveryRepository,
                                   CustomerRepository customerRepository,
                                   PizzaOrderRepository pizzaOrderRepository,
                                   PizzaRepository pizzaRepository,
                                   CustomerService customerService) {
        this.deliveryRepository = deliveryRepository;
        this.customerRepository = customerRepository;
        this.pizzaOrderRepository = pizzaOrderRepository;
        this.pizzaRepository = pizzaRepository;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Delivery>> getOrders() {
        if (deliveryRepository.count() != 0) {
            return ResponseEntity.ok(deliveryRepository.findAll());
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/order")
    public ResponseEntity<Delivery> addOrder(@RequestBody DeliveryOrderForm deliveryOrderForm) {
        Delivery delivery = new Delivery();

        if (customerRepository.findById(deliveryOrderForm.getCustomerId()).isPresent()) {
            Customer customer = customerRepository.findById(deliveryOrderForm.getCustomerId()).get();
            delivery.setCustomer(customer);
            delivery.setSubmissionDate(Instant.now());
            List<Delivery> deliveryList = customer.getDeliveries();
            for (PizzaOrderForm order : deliveryOrderForm.getPizzaOrders()) {
                PizzaOrder pizzaOrder = new PizzaOrder();

                if (pizzaRepository.findById(order.getPizzaId()).isPresent()) {
                    pizzaOrder.setPizza(pizzaRepository.findById(order.getPizzaId()).get());
                    pizzaOrder.setQuantity(order.getQuantity());
                    pizzaOrder.setPizzaSize(order.getPizzaSize());

                    PizzaOrder savedPizzaOrder = pizzaOrderRepository.save(pizzaOrder);
                    delivery.getPizzaOrder().add(savedPizzaOrder);
                    deliveryList.add(delivery);
                } else {
                    throw new PizzaNotFoundException(order.getPizzaId().toString());
                }
            }
        } else {
            throw new CustomerNotFoundException(deliveryOrderForm.getCustomerId());
        }
        return ResponseEntity.ok(deliveryRepository.save(delivery));
    }
}
