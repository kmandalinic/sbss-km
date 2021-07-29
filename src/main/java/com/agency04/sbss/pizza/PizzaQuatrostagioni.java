package com.agency04.sbss.pizza;

public class PizzaQuatrostagioni implements Pizza {
    @Override
    public String getName(){
        return "Quattro Stagioni";
    }
    @Override
    public  String getIngredients(){
        return "Tomato sauce, Mozzarella, Mushrooms, Ham, Artichokes, Olives, Oregano";
    }
}
