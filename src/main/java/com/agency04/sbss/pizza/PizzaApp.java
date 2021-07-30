package com.agency04.sbss.pizza;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PizzaApp {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        Pizza margherita = new PizzaMargherita();
        Pizza fruttidimare = new PizzaFruttidimare();
        Pizza quattrostagioni = new PizzaQuatrostagioni();


        PizzaDeliveryService pizzaDeliveryService = context.getBean("deliveryService", PizzaDeliveryService.class);
        System.out.println(pizzaDeliveryService.orderPizza(quattrostagioni));

        context.close();
    }

}
