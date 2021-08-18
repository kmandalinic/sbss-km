package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.form.DeliveryOrderForm;
import com.agency04.sbss.pizza.model.Delivery;


import java.util.ArrayList;
import java.util.List;

public interface PizzaDeliveryService {
    List<Delivery> deliveryList();
    Delivery addDeliveryOrder(DeliveryOrderForm deliveryOrderForm);
}
