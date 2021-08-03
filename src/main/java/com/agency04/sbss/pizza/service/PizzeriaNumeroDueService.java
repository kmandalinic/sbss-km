package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.Pizza;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Locale;

@Service
public class PizzeriaNumeroDueService implements PizzeriaService {

    @Value("${due.name}")
    private String name;
    @Value("${due.address}")
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
        return "Make pizza " + pizza.getName() + " with: "+ pizza.getIngredients() + " (by " + name + " at " + address +")" ;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @PostConstruct
    public void startPizzeriaDue(){
        System.out.println("Pizzeria " + name.toUpperCase(Locale.ROOT) + " starting!");
    }
    @PreDestroy
    public void stopPizzeriaDue(){
        System.out.println("Closing pizzeria " + name.toUpperCase(Locale.ROOT) + "!");
    }
}
