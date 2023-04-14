package org.example.exProg.services;

import org.example.exProg.entity.Customer;
import org.example.exProg.repository.CustomerRepository;

public class CustomerService {
    public int money;

    private Customer customer;
    private CustomerRepository customerRepository;

    public CustomerService(Customer customer) {
        this.customer = customer;
    }

    public void addMoney(int money){
        int newSold = customer.getSold() + money ;
        customer.setSold(newSold);
    }

    public void takeMoney(int money){
        int newSold = customer.getSold() - money ;
        customer.setSold(newSold);
    }

    public void createCustomer(Customer customer) {

    }

}
