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

    /**
     * Increase sold
     * @param money
     */
    public void addMoney(int money){
        int newSold = customer.getSold() + money ;
        customer.setSold(newSold);
    }

    /**
     * Send the new customer to the method for insertion in json file
     * @param customer
     */
    public void insertCustomerInJsonFile(Customer customer){
        customerRepository = new CustomerRepository();
        customerRepository.writeJson(customer);
    }

    /**
     * Decrease sold
     * @param money
     */
    public void takeMoney(int money){
        int newSold = customer.getSold() - money ;
        customer.setSold(newSold);
    }
}
