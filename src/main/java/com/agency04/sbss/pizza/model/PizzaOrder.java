package com.agency04.sbss.pizza.model;

import javax.persistence.*;

@Entity
public class PizzaOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pizzaOrderId;

    @ManyToOne
    private Pizza pizza;

    @Enumerated(EnumType.STRING)
    private PizzaSize pizzaSize;

    private String quantity;

    public PizzaOrder() {
    }

    public PizzaOrder(Pizza pizza, PizzaSize pizzaSize, String quantity) {
        this.pizza = pizza;
        this.pizzaSize = pizzaSize;
        this.quantity = quantity;
    }

    public Long getPizzaOrderId() {
        return pizzaOrderId;
    }

    public void setPizzaOrderId(Long pizzaOrderId) {
        this.pizzaOrderId = pizzaOrderId;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public PizzaSize getPizzaSize() {
        return pizzaSize;
    }

    public void setPizzaSize(PizzaSize pizzaSize) {
        this.pizzaSize = pizzaSize;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
