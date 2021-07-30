package com.agency04.sbss.pizza;

public class PizzaDeliveryServiceImpl implements PizzaDeliveryService{

    private PizzeriaNumeroUnoService pizzeriaNumeroUnoService;
    private PizzeriaNumeroDueService pizzeriaNumeroDueService;

    public PizzaDeliveryServiceImpl(PizzeriaNumeroUnoService pizzeriaNumeroUnoService) {
        this.pizzeriaNumeroUnoService = pizzeriaNumeroUnoService;
    }

    public void setPizzeriaNumeroDue(PizzeriaNumeroDueService pizzeriaNumeroDueService) {
        this.pizzeriaNumeroDueService = pizzeriaNumeroDueService;
    }

    @Override
    public String orderPizza(Pizza pizza){

        return  "New order: \n" + pizzeriaNumeroDueService.makePizza(pizza);
    }

}
