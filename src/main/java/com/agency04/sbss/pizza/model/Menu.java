package com.agency04.sbss.pizza.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Menu {
    private Set<Pizza> pizzas;
    private List<PizzaSize> pizzaSizes;

    public Menu(){
        configureMenu();
    }

    public Set<Pizza> getPizzas(){
        return pizzas;
    }

    public List<PizzaSize> getPizzaSizes() {
        return pizzaSizes;
    }

    @Override
    public String toString(){
        StringBuilder pizzaString = new StringBuilder();
        for(Pizza pizza:pizzas){
            pizzaString.append("\t" + pizza.getName()+ pizza.getIngredients() +"\n");
        }
        return "Menu\n" + "PIZZA\n" + pizzaString + "PIZZA SIZE\n\t" + pizzaSizes ;
    }
    private void configureMenu(){
        Set<Pizza> pizzaSet = new HashSet<>();
        pizzaSet.add(new PizzaMargherita());
        pizzaSet.add(new PizzaFruttidimare());
        pizzaSet.add(new PizzaQuatrostagioni());
        this.pizzas = pizzaSet;

        List<PizzaSize> sizes = new ArrayList<>();
        sizes.add(PizzaSize.SMALL);
        sizes.add(PizzaSize.MEDIUM);
        sizes.add(PizzaSize.LARGE);
        sizes.add(PizzaSize.JUMBO);
        this.pizzaSizes=sizes;
    }
}

