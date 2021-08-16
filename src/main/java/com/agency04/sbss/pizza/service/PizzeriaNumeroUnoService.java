package com.agency04.sbss.pizza.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


@Service
@Primary
public class PizzeriaNumeroUnoService implements PizzeriaService {
    @Value("${uno.name}")
    private String name;
    @Value("${uno.address}")
    private String address;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @PostConstruct
    public void purchaseIngredients() {
        System.out.println(name + " starting!");
    }

    @PreDestroy
    public void makePurchase() {
        System.out.println("Closing " + name + "!");
    }
}
