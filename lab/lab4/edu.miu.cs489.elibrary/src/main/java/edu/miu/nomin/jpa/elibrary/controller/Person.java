package edu.miu.nomin.jpa.elibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class Person {
    private Address address;
    @Autowired
    public Person(Address address) {   // Spring injects Address
        this.address = address;
    }
    public void showAddress() {
        System.out.println("Lives in: " + address.getCity());
    }
}

@Component
class Address {
    public String getCity() {
        return "New York";
    }
}
