package com.agency04.sbss.pizza;

public class PizzaDeliveryServiceImpl implements PizzaDeliveryService{

    private PizzeriaNumeroUno pizzeriaNumeroUno;
    private PizzeriaNumeroDue pizzeriaNumeroDue;

    public PizzaDeliveryServiceImpl(PizzeriaNumeroUno pizzeriaNumeroUno) {
        this.pizzeriaNumeroUno = pizzeriaNumeroUno;
    }

    public void setPizzeriaNumeroDue(PizzeriaNumeroDue pizzeriaNumeroDue) {
        this.pizzeriaNumeroDue = pizzeriaNumeroDue;
    }

    @Override
    public String orderPizza(Pizza pizza){

        return  "New order: \n" + pizzeriaNumeroUno.makePizza(pizza);
    }

}
