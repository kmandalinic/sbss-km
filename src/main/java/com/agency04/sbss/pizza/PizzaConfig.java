package com.agency04.sbss.pizza;

import com.agency04.sbss.pizza.service.PizzeriaNumeroTreService;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.agency04.sbss")
@PropertySource("application.properties")
public class PizzaConfig {
    @Bean
    @Primary
    public PizzeriaNumeroTreService pizzeriaNumeroTreService(){
        return new PizzeriaNumeroTreService();
    }
}