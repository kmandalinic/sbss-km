package com.agency04.sbss.pizza.exception;

public class CustomerAlreadyExistsException extends RuntimeException {

    public CustomerAlreadyExistsException(String message) {
        super("Customer with username: [" + message + "] already exists!");
    }
}
