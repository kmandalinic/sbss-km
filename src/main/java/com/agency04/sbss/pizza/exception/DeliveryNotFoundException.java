package com.agency04.sbss.pizza.exception;

public class DeliveryNotFoundException extends RuntimeException {

    public DeliveryNotFoundException() {

        super("There are no deliveries!");
    }
}
