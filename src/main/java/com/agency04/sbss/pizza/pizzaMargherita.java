package com.agency04.sbss.pizza;

public class pizzaMargherita implements Pizza{
    @Override
    public String getName(){
        return "Margherita";
    }
    @Override
    public String getIngredients(){
        return "Mozzarella, Tomato sauce, Oregano, Olives";
    }
}
