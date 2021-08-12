package com.agency04.sbss.pizza.controller;

import com.agency04.sbss.pizza.service.PizzaDeliveryServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pizzeria")
public class PizzeriaController {

    private PizzaDeliveryServiceImpl pizzaDeliveryService;

    public PizzeriaController(PizzaDeliveryServiceImpl pizzaDeliveryService) {
        this.pizzaDeliveryService = pizzaDeliveryService;
    }

    @GetMapping("")
    public String getDetails() {
        return pizzaDeliveryService.getPizzeriaInfo();
    }

    @GetMapping("/menu")
    public String getMenu() {
        return pizzaDeliveryService.getMenu();
    }
}
