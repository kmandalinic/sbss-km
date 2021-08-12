package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.Menu;
import com.agency04.sbss.pizza.model.Pizza;
import org.springframework.beans.factory.annotation.Value;


public class PizzeriaNumeroTreService implements  PizzeriaService{
    @Value("${tre.name}")
    private String name;
    @Value("${tre.address}")
    private String address;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public String makePizza(Pizza pizza) {
        return "Make pizza " + pizza.getName() + " with: "+ pizza.getIngredients() + " (by " + name + " at "+ address + ")";
    }
    @Override
    public Menu getMenu() {
        return null;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
