package com.agency04.sbss.pizza;

import com.agency04.sbss.pizza.model.Pizza;
import com.agency04.sbss.pizza.model.PizzaMargherita;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import com.agency04.sbss.pizza.service.PizzaDeliveryServiceImpl;
import com.agency04.sbss.pizza.service.PizzeriaService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class PizzaApp {

    public static void main(String[] args) {


        ConfigurableApplicationContext context = SpringApplication.run(PizzaApp.class, args);

        Pizza margherita = new PizzaMargherita();
        PizzeriaService pizzeriaService = context.getBean(PizzeriaService.class);
        System.out.println(pizzeriaService.makePizza(margherita));
        PizzaDeliveryService pizzaDeliveryService = context.getBean(PizzaDeliveryService.class);

        System.out.println(pizzaDeliveryService.orderPizza(margherita));
        context.close();
    }

}
