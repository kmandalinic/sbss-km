package com.agency04.sbss.pizza.controller;

import com.agency04.sbss.pizza.model.DeliveryOrderForm;
import com.agency04.sbss.pizza.service.PizzaDeliveryServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/delivery")
public class PizzaDeliveryController {

    private PizzaDeliveryServiceImpl pizzaDeliveryService;

    public PizzaDeliveryController(PizzaDeliveryServiceImpl deliveryService) {
        this.pizzaDeliveryService = deliveryService;
    }

    @PostMapping("/order")
    public void placeAnOrder(@RequestBody DeliveryOrderForm deliveryOrderForm) {
        pizzaDeliveryService.orderPizza(deliveryOrderForm);
    }

    @GetMapping("/list")
    public List<DeliveryOrderForm> listOrders() {
        return pizzaDeliveryService.getOrders();
    }
}
