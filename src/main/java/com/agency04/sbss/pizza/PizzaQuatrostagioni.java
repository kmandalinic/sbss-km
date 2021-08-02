package com.agency04.sbss.pizza;

import java.util.Set;

public class PizzaQuatrostagioni implements Pizza {
    private final Set<PizzaIngredient> ingredients = Set.of(PizzaIngredient.TOMATO_SAUCE, PizzaIngredient.HAM, PizzaIngredient.OLIVES, PizzaIngredient.OREGANO, PizzaIngredient.MOZZARELLA, PizzaIngredient.ARTICHOKES, PizzaIngredient.MUSHROOMS);
    @Override
    public String getName(){
        return "Quattro Stagioni";
    }
    @Override
    public Set<PizzaIngredient> getIngredients(){
        return ingredients;
    }
}
