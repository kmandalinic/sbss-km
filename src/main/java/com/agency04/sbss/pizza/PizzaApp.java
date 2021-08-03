package com.agency04.sbss.pizza;

import com.agency04.sbss.pizza.model.Pizza;
import com.agency04.sbss.pizza.model.PizzaMargherita;
import com.agency04.sbss.pizza.service.PizzeriaService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class PizzaApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PizzaConfig.class);

        Pizza margherita = new PizzaMargherita();
        PizzeriaService pizzeriaService = context.getBean(PizzeriaService.class);

        System.out.println(pizzeriaService.makePizza(margherita));

        context.close();
    }

}
