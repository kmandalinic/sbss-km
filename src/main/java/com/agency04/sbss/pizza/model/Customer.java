package com.agency04.sbss.pizza.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Customer {

    @Id
    private String userName;

    @OneToOne(cascade = CascadeType.ALL)
    private CustomerDetails customerDetails;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Delivery> deliveries = new ArrayList<>();

    public Customer(String userName) {
        this.userName = userName;
    }

    public Customer() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public CustomerDetails getCustomerDetails() {
        return customerDetails;
    }

    public void setCustomerDetails(CustomerDetails customerDetails) {
        this.customerDetails = customerDetails;
    }

    public List<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(List<Delivery> deliveries) {
        this.deliveries = deliveries;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return userName.equals(customer.userName) && Objects.equals(customerDetails, customer.customerDetails) && Objects.equals(deliveries, customer.deliveries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, customerDetails, deliveries);
    }
}
