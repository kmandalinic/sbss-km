package com.agency04.sbss.pizza;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class PizzeriaNumeroDueService implements PizzeriaService{

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
    public void purchaseIngredients(){
        System.out.println("Order fresh ingredients every day for DUE!");
    }
    @PreDestroy
    public void makePurchase(){
        System.out.println("Purchase is made every day at 9am!");
    }
}
