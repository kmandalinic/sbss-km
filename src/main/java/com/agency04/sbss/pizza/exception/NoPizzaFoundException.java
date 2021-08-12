package com.agency04.sbss.pizza.exception;

public class NoPizzaFoundException extends RuntimeException{

    public NoPizzaFoundException(String message) {
        super("You have entered wrong pizza name [" + message + "]");
    }
}
