package com.agency04.sbss.pizza.service;

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

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
