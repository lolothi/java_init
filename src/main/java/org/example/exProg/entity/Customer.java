package org.example.exProg.entity;

import org.example.exProg.services.CustomerService;

public class Customer {
    private String firstname;
    private String lastname;
    private String email;

    private Account account;
    private CustomerService customerService;


    public Customer(String lastname, int initialSold) {
        this.lastname = lastname;
        account = new Account(0);
    }

    public int getSold() {
        return account.getSold();
    }
    public void setSold(int newSold) {
        account.setSold(newSold);
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
