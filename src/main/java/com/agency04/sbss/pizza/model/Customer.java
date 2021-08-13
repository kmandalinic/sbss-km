package com.agency04.sbss.pizza.model;

public class Customer {
    private String userName;
    private String address;
    private Long phoneNumber;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Customer: \nUsername: " + userName + " Phone number: " + phoneNumber + " Address: " + address;
    }
}
