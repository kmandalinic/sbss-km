package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.Menu;
import com.agency04.sbss.pizza.model.Pizza;

public interface PizzeriaService {
    String getName();
    String getAddress();
    String makePizza(Pizza pizza);
    Menu getMenu();

}
