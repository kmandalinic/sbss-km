package com.agency04.sbss.pizza;

import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import com.agency04.sbss.pizza.service.PizzaDeliveryServiceImpl;
import com.agency04.sbss.pizza.service.PizzeriaNumeroUnoService;
import com.agency04.sbss.pizza.service.PizzeriaService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String getDetails(){
        return pizzaDeliveryService.getPizzeriaInfo();
    }
}
