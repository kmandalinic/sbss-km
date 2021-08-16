package com.agency04.sbss.pizza.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.Instant;
import java.util.*;

@Entity
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deliveryId;

    private Instant submissionDate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Customer customer;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PizzaOrder> pizzaOrder = new ArrayList<>();

    public Delivery() {
    }

    public Delivery(Instant submissionDate, Customer customer, List<PizzaOrder> pizzaOrder) {
        this.submissionDate = submissionDate;
        this.customer = customer;
        this.pizzaOrder = pizzaOrder;
    }

    public Long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }

    public Instant getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Instant submissionDate) {
        this.submissionDate = submissionDate;
    }

    public String getUserName() {
        return customer.getUserName();
    }

    public List<PizzaOrder> getPizzaOrder() {
        return pizzaOrder;
    }

    public void setPizzaOrder(List<PizzaOrder> pizzaOrder) {
        this.pizzaOrder = pizzaOrder;
    }

    @JsonIgnore
    public Customer getCustomer() {
        return customer;
    }

    @JsonIgnore
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Delivery)) return false;
        Delivery delivery = (Delivery) o;
        return deliveryId.equals(delivery.deliveryId) && Objects.equals(submissionDate, delivery.submissionDate) && customer.equals(delivery.customer) && Objects.equals(pizzaOrder, delivery.pizzaOrder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deliveryId, submissionDate, customer, pizzaOrder);
    }
}
