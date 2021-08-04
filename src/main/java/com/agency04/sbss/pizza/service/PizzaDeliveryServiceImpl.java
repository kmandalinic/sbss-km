package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
public class PizzaDeliveryServiceImpl implements PizzaDeliveryService {
    private PizzeriaService pizzeriaService;

    //@Qualifier("pizzeriaNumeroUnoService") has a higher priority than @Primary
    @Autowired
    public void setPizzeriaService(PizzeriaService pizzeriaService) {
        this.pizzeriaService = pizzeriaService;
    }

    @Override
    public String orderPizza(Pizza pizza){
        return  "New order: \n" + pizzeriaService.makePizza(pizza);
    }

}
