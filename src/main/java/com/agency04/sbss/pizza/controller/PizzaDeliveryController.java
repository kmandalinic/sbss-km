package com.agency04.sbss.pizza.controller;

import com.agency04.sbss.pizza.form.DeliveryOrderForm;
import com.agency04.sbss.pizza.model.*;
import com.agency04.sbss.pizza.service.PizzaDeliveryServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/delivery")
public class PizzaDeliveryController {

    private final PizzaDeliveryServiceImpl pizzaDeliveryService;

    public PizzaDeliveryController(PizzaDeliveryServiceImpl pizzaDeliveryService) {
        this.pizzaDeliveryService = pizzaDeliveryService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Delivery>> getOrders() {
        return  ResponseEntity.ok().body(pizzaDeliveryService.deliveryList());
    }

    @PostMapping("/order")
    public ResponseEntity<Delivery> addOrder(@RequestBody DeliveryOrderForm deliveryOrderForm) {
        return ResponseEntity.ok().body(pizzaDeliveryService.addDeliveryOrder(deliveryOrderForm));
    }
}
