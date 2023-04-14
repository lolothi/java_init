package org.example.exProg.controller;

import org.example.exProg.entity.Customer;
import org.example.exProg.services.CustomerService;

import java.io.IOException;
import java.util.Scanner;

public class CustomerController {
    Scanner scanner = new Scanner(System.in);
    public void playMenu() throws IOException {
        System.out.println("--------MENU-------");
        System.out.println("1.Créer Client \n2.Trouver client\nVotre Choix?");
        int choiceMenu = scanner.nextInt();

        switch(choiceMenu){
            case 1:
                System.out.println("Choix 1");
                createCustomer();
                break;
            case 2:
                System.out.println("Choix 2");
                break;
            default:
                System.out.println("terminé");
        }
    }

    public void createCustomer() throws IOException {
        Scanner scannerCreate = new Scanner(System.in);
        System.out.println("Nom nouveau client:");
        String customerName = scannerCreate.nextLine();
        System.out.println("Solde initial client:");
        int customerSold = scannerCreate.nextInt();

        Customer customer1 = new Customer(customerName, customerSold);
        CustomerService customerService1 = new CustomerService(customer1);

        System.out.println("Client créé: " + customer1.getLastname() + " " + customer1.getSold());

        this.playMenu();

    }
}
