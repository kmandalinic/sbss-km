package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.exception.NoPizzaFoundException;
import com.agency04.sbss.pizza.model.DeliveryOrderForm;
import com.agency04.sbss.pizza.model.Menu;
import com.agency04.sbss.pizza.model.PizzaOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PizzaDeliveryServiceImpl implements PizzaDeliveryService {
    private PizzeriaService pizzeriaService;
    private List<DeliveryOrderForm> orders = new ArrayList<>();

    //@Qualifier("pizzeriaNumeroUnoService") has a higher priority than @Primary
    @Autowired
    public void setPizzeriaService(PizzeriaService pizzeriaService) {
        this.pizzeriaService = pizzeriaService;
    }

    @Override
    public void orderPizza(DeliveryOrderForm deliveryOrderForm) {
        for (PizzaOrder order : deliveryOrderForm.getPizzaOrders()) {
            if (pizzeriaService.getMenu().getPizzas().stream().filter(pizza -> pizza.getName().equals(order.getPizza()))
                    .findFirst().orElse(null) == null) {
                throw new NoPizzaFoundException(order.getPizza());
            }
        }
        orders.add(deliveryOrderForm);
    }

    public List<DeliveryOrderForm> getOrders() {
        return orders;
    }

    public String getPizzeriaInfo() {
        return pizzeriaService.getName() + " " + "Address: " + pizzeriaService.getAddress();
    }

    public Menu getMenu() {
        return pizzeriaService.getMenu();
    }

}
