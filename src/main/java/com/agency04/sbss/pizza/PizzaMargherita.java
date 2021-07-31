package com.agency04.sbss.pizza;

import java.util.Set;

public class PizzaMargherita implements Pizza{
    private final Set<PizzaIngredient> ingredients = Set.of(PizzaIngredient.MOZZARELLA,PizzaIngredient.TOMATO_SAUCE, PizzaIngredient.OLIVES, PizzaIngredient.OREGANO);
    @Override
    public String getName(){
        return "Margherita";
    }
    @Override
    public Set<PizzaIngredient> getIngredients(){

        return ingredients;
    }
}
