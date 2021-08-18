package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.exception.CustomerNotFoundException;
import com.agency04.sbss.pizza.exception.DeliveryNotFoundException;
import com.agency04.sbss.pizza.exception.PizzaNotFoundException;
import com.agency04.sbss.pizza.form.DeliveryOrderForm;
import com.agency04.sbss.pizza.form.PizzaOrderForm;
import com.agency04.sbss.pizza.model.Customer;
import com.agency04.sbss.pizza.model.Delivery;
import com.agency04.sbss.pizza.model.PizzaOrder;
import com.agency04.sbss.pizza.repository.CustomerRepository;
import com.agency04.sbss.pizza.repository.DeliveryRepository;
import com.agency04.sbss.pizza.repository.PizzaOrderRepository;
import com.agency04.sbss.pizza.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class PizzaDeliveryServiceImpl implements PizzaDeliveryService {

    private PizzeriaService pizzeriaService;

    private final PizzaOrderRepository pizzaOrderRepository;
    private final DeliveryRepository deliveryRepository;
    private final CustomerRepository customerRepository;
    private final PizzaRepository pizzaRepository;

    public PizzaDeliveryServiceImpl(PizzaOrderRepository pizzaOrderRepository,
                                    DeliveryRepository deliveryRepository,
                                    CustomerRepository customerRepository,
                                    PizzaRepository pizzaRepository) {
        this.pizzaOrderRepository = pizzaOrderRepository;
        this.deliveryRepository = deliveryRepository;
        this.customerRepository = customerRepository;
        this.pizzaRepository = pizzaRepository;
    }

    @Autowired
    public void setPizzeriaService(PizzeriaService pizzeriaService) {
        this.pizzeriaService = pizzeriaService;
    }

    public String getPizzeriaInfo() {
        return pizzeriaService.getName() + " " + "Address: " + pizzeriaService.getAddress();
    }

    @Override
    public List<Delivery> deliveryList() {
        if (deliveryRepository.count() == 0) {

            throw new DeliveryNotFoundException();
        }
        return deliveryRepository.findAll();
    }

    @Override
    public Delivery addDeliveryOrder(DeliveryOrderForm deliveryOrderForm) {
        Delivery delivery = new Delivery();

        if (customerRepository.findById(deliveryOrderForm.getCustomerId()).isPresent()) {
            Customer customer = customerRepository.findById(deliveryOrderForm.getCustomerId()).get();
            delivery.setCustomer(customer);
            delivery.setSubmissionDate(Instant.now());
            List<Delivery> deliveryList = customer.getDeliveries();
            for (PizzaOrderForm order : deliveryOrderForm.getPizzaOrders()) {
                PizzaOrder pizzaOrder = new PizzaOrder();

                if (pizzaRepository.findById(order.getPizzaId()).isPresent()) {
                    pizzaOrder.setPizza(pizzaRepository.findById(order.getPizzaId()).get());
                    pizzaOrder.setQuantity(order.getQuantity());
                    pizzaOrder.setPizzaSize(order.getPizzaSize());

                    PizzaOrder savedPizzaOrder = pizzaOrderRepository.save(pizzaOrder);
                    delivery.getPizzaOrder().add(savedPizzaOrder);
                    deliveryList.add(delivery);
                } else {
                    throw new PizzaNotFoundException(order.getPizzaId().toString());
                }
            }
        } else {
            throw new CustomerNotFoundException(deliveryOrderForm.getCustomerId());
        }
        return deliveryRepository.save(delivery);
    }
}
