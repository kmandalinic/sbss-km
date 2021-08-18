package com.agency04.sbss.pizza.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pizzaId;

    private String name;

    @ElementCollection
    private Set<PizzaIngredient> ingredients;

    public Long getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(Long pizzaId) {
        this.pizzaId = pizzaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<PizzaIngredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<PizzaIngredient> pizzaIngredient) {
        this.ingredients = pizzaIngredient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pizza)) return false;
        Pizza pizza = (Pizza) o;
        return pizzaId.equals(pizza.pizzaId) && Objects.equals(name, pizza.name) && Objects.equals(ingredients, pizza.ingredients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pizzaId, name, ingredients);
    }
}
