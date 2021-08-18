package com.agency04.sbss.pizza.form;

import com.agency04.sbss.pizza.model.PizzaSize;

public class PizzaOrderForm {

    private Long pizzaId;
    private PizzaSize pizzaSize;
    private String quantity;

    public Long getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(Long pizzaId) {
        this.pizzaId = pizzaId;
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
