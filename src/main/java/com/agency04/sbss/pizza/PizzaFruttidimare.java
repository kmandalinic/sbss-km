package com.agency04.sbss.pizza;

import java.util.Set;

public class PizzaFruttidimare implements Pizza {
    private final Set<PizzaIngredient> ingredients = Set.of(PizzaIngredient.TOMATO_SAUCE, PizzaIngredient.SEAFOOD);

    @Override
    public String getName(){
        return "Frutti di Mare";
    }
    @Override
    public Set getIngredients(){
        return ingredients;
    }



}
