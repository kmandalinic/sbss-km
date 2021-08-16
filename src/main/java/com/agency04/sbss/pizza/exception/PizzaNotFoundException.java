package com.agency04.sbss.pizza.exception;

public class PizzaNotFoundException extends RuntimeException {

    public PizzaNotFoundException(String message) {

        super("Pizza not found! Given ID was: " + message);
    }
}
