package org.example.exProg.services;

import org.example.exProg.entity.Account;
import org.example.exProg.entity.Customer;

public class CustomerService {
    public int money;

    private Customer customer;

    public CustomerService(Customer customer) {
        this.customer = customer;
    }

    /*public int getSold() {
            return account.getSold();
        } */

    public void addMoney(int money){
        int newSold = customer.getSold() + money ;
        customer.setSold(newSold);
    }

    public void takeMoney(int money){
        int newSold = customer.getSold() - money ;
        customer.setSold(newSold);
    }

}
