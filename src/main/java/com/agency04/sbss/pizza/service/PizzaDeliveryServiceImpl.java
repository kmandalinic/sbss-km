package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.PizzaOrder;
import com.agency04.sbss.pizza.repository.PizzaOrderRepository;
import com.agency04.sbss.pizza.repository.PizzaRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PizzaDeliveryServiceImpl implements PizzaDeliveryService {
    private PizzeriaService pizzeriaService;
    private List<PizzaOrder> orders = new ArrayList<>();

    private PizzaOrderRepository pizzaOrderRepository;

    public PizzaDeliveryServiceImpl(PizzaOrderRepository pizzaOrderRepository) {
        this.pizzaOrderRepository = pizzaOrderRepository;
    }

    //@Qualifier("pizzeriaNumeroUnoService") has a higher priority than @Primary
    @Autowired
    public void setPizzeriaService(PizzeriaService pizzeriaService) {
        this.pizzeriaService = pizzeriaService;
    }

    @Override
    public void orderPizza(PizzaOrder pizzaOrder) {

    }

    @JsonIgnore
    public List<PizzaOrder> getOrders() {
        return pizzaOrderRepository.findAll();
    }

    public String getPizzeriaInfo() {
        return pizzeriaService.getName() + " " + "Address: " + pizzeriaService.getAddress();
    }
}
