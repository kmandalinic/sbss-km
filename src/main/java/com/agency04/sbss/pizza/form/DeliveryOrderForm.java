package com.agency04.sbss.pizza.form;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class DeliveryOrderForm {

    private String customerId;
    private List<PizzaOrderForm> pizzaOrders = new ArrayList<>();
    private Instant date;

    public DeliveryOrderForm(String customerId, List<PizzaOrderForm> pizzaOrders, Instant date) {
        this.customerId = customerId;
        this.pizzaOrders = pizzaOrders;
        this.date = date;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public List<PizzaOrderForm> getPizzaOrders() {
        return pizzaOrders;
    }

    public void setPizzaOrders(List<PizzaOrderForm> pizzaOrders) {
        this.pizzaOrders = pizzaOrders;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }
}
