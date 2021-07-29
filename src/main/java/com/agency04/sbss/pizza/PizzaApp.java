package com.agency04.sbss.pizza;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;

public class PizzaApp {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        Pizza margherita = new pizzaMargherita();
        Pizza fruttidimare = new PizzaFruttidimare();


        PizzaDeliveryService pizzaDeliveryService = context.getBean("deliveryService", PizzaDeliveryService.class);
        System.out.println(pizzaDeliveryService.orderPizza(margherita));
    }

}
