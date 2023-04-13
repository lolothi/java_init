package org.example.exProg.controller;

import org.example.exProg.entity.Account;
import org.example.exProg.services.AccountService;

import java.io.IOException;
import java.util.Scanner;

public class AccountController {
    Scanner scanner = new Scanner(System.in);

    AccountService accountService = new AccountService();

    public void playMenu() throws IOException {
        System.out.println("--------MENU-------");
        System.out.println("1.Créer Client \n2.Trouver client\nVotre Choix?");
        int choiceMenu = scanner.nextInt();

        switch(choiceMenu){
            case 1:
                System.out.println("Choix 1");
                createAccount();
                break;
            case 2:
                System.out.println("Choix 2");
                break;
            default:
                System.out.println("terminé");
        }
    }

    public void createAccount() throws IOException {
        Scanner scannerCreate = new Scanner(System.in);
        Account account = new Account();

        System.out.println("Nom nouveau client:");
        String nameAccount = scannerCreate.nextLine();

        account.setName(nameAccount);

        System.out.println(accountService.createAccount(account));
        this.playMenu();

    }

}
