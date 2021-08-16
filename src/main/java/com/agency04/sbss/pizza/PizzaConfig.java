package com.agency04.sbss.pizza;

import com.agency04.sbss.pizza.service.PizzeriaNumeroTreService;
import org.springframework.context.annotation.*;

@Configuration
public class PizzaConfig {
    @Bean
    public PizzeriaNumeroTreService pizzeriaNumeroTreService(){
        return new PizzeriaNumeroTreService();
    }
}