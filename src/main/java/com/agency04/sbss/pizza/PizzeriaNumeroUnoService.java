package com.agency04.sbss.pizza;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PizzeriaNumeroUnoService implements PizzeriaService {
    @Value("${uno.name}")
    private String name;
    @Value("${uno.address}")
    private  String address;

    @Override
    public String getName(){
        return name;
    }
    @Override
    public  String getAddress(){
        return address;
    }
    @Override
    public  String makePizza(Pizza pizza){
        return "Make pizza " + pizza.getName() + " with: "+ pizza.getIngredients() + " (by " + name + " at "+ address + ")";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
