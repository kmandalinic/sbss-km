package com.agency04.sbss.pizza;

import com.agency04.sbss.pizza.service.PizzaDeliveryServiceImpl;
import com.agency04.sbss.pizza.service.PizzeriaNumeroTreService;
import com.agency04.sbss.pizza.service.PizzeriaNumeroUnoService;
import com.agency04.sbss.pizza.service.PizzeriaService;
import org.springframework.beans.factory.annotation.Autowired;
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