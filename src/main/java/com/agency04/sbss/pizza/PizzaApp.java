package com.agency04.sbss.pizza;

import com.agency04.sbss.pizza.model.Pizza;
import com.agency04.sbss.pizza.model.PizzaMargherita;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import com.agency04.sbss.pizza.service.PizzeriaService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PizzaApp {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        Pizza margherita = new PizzaMargherita();

        
        PizzeriaService pizzeriaService = context.getBean("pizzeriaNumeroUnoService", PizzeriaService.class);
        PizzeriaService pizzeriaService1 = context.getBean("pizzeriaNumeroUnoService", PizzeriaService.class);
        boolean result = (pizzeriaService==pizzeriaService1);
        System.out.println(result);
        System.out.println("Memory location for pizzeriaService: " + pizzeriaService);
        System.out.println("Memory location for pizzeriaService: " + pizzeriaService1);
        /*
        Default scope is singleton, they are pointing to the same object (memory location is the same)
        when we change scope to prototype, two objects are created (different memory location)
        Prototype: new object is created each time it's injected, Singleton: same object is returned each time
        Note: prototype-scoped objects are not destroyed by default like singleton-scoped objects
        */

        context.close();
    }

}
