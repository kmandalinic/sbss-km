package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PizzaDeliveryServiceImpl implements PizzaDeliveryService {

    private PizzeriaNumeroUnoService pizzeriaNumeroUnoService;
    private PizzeriaNumeroDueService pizzeriaNumeroDueService;

    @Autowired
    public PizzaDeliveryServiceImpl(@Qualifier("pizzeriaNumeroUnoService")PizzeriaNumeroUnoService pizzeriaNumeroUnoService) {
        this.pizzeriaNumeroUnoService = pizzeriaNumeroUnoService;
    }

    @Autowired
    public void setPizzeriaNumeroDue(@Qualifier("pizzeriaNumeroDueService")PizzeriaNumeroDueService pizzeriaNumeroDueService) {
        this.pizzeriaNumeroDueService = pizzeriaNumeroDueService;
    }

    @Override
    public String orderPizza(Pizza pizza){

        return  "New order: \n" + pizzeriaNumeroUnoService.makePizza(pizza) + "\n" + pizzeriaNumeroDueService.makePizza(pizza);
    }


}
