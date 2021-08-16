package com.agency04.sbss.pizza.controller;

import com.agency04.sbss.pizza.model.Menu;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import com.agency04.sbss.pizza.service.PizzaDeliveryServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pizzeria")
public class PizzeriaController {

    private final PizzaDeliveryServiceImpl pizzaDeliveryService;
    private final Menu menu;

    public PizzeriaController(PizzaDeliveryServiceImpl pizzaDeliveryService, Menu menu) {
        this.pizzaDeliveryService = pizzaDeliveryService;
        this.menu = menu;
    }

    @GetMapping
    ResponseEntity<PizzaDeliveryService> getDetails() {
        return new ResponseEntity<>(pizzaDeliveryService, HttpStatus.OK);
    }

    @GetMapping("/menu")
    ResponseEntity<Menu> getMenu() {
        return new ResponseEntity<>(menu, HttpStatus.OK);
    }
}
