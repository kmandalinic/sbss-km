package com.agency04.sbss.pizza.model;

import com.agency04.sbss.pizza.model.PizzaIngredient;

import java.util.Set;

public interface Pizza {
    String  getName();
    Set<PizzaIngredient> getIngredients();
}
