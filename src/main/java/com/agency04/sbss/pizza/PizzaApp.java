package com.agency04.sbss.pizza;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PizzaApp {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        Pizza margherita = new PizzaMargherita();


        PizzaDeliveryService pizzaDeliveryService = context.getBean("pizzaDeliveryServiceImpl", PizzaDeliveryService.class);
        System.out.println(pizzaDeliveryService.orderPizza(margherita));

        context.close();
    }

}
