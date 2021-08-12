package com.agency04.sbss.pizza.model;

import java.util.List;

public class DeliveryOrderForm {

    private Customer customer;
    private List<PizzaOrder> pizzaOrders;

    public DeliveryOrderForm(Customer customer, List<PizzaOrder> pizzaOrders) {
        this.customer = customer;
        this.pizzaOrders = pizzaOrders;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<PizzaOrder> getPizzaOrders() {
        return pizzaOrders;
    }

    public void addOrder(PizzaOrder order) {
        pizzaOrders.add(order);
    }
}
