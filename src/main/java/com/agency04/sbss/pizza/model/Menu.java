package com.agency04.sbss.pizza.model;

import com.agency04.sbss.pizza.repository.PizzaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Menu {

    private final PizzaRepository pizzaRepository;

    public Menu(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    public List<Pizza> getPizzas(){
        return pizzaRepository.findAll();
    }
    public List<PizzaSize> getPizzaSizes(){
        List<PizzaSize> sizes = new ArrayList<>();
        sizes.add(PizzaSize.SMALL);
        sizes.add(PizzaSize.MEDIUM);
        sizes.add(PizzaSize.LARGE);
        sizes.add(PizzaSize.JUMBO);
        return sizes;
    }
}
