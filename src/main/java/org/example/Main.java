package org.example;

import org.example.exClass.Rectangle;
import org.example.exClass.Square;
import org.example.exEntrainement.Exo3h;
import org.example.exEntrainement.SingletonMemoryAddress;
import org.example.exProg.controller.CustomerController;
import org.example.exProg.entity.Customer;
import org.example.exProg.services.CustomerService;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static String textInput="Hello world!";

    public static void main(String[] args) throws IOException {

        //Reverse phrase
        System.out.println("Entrez une phrase: ");
        Scanner scannerPhraseInput = new Scanner(System.in);
        String phraseInput = scannerPhraseInput.nextLine();
        System.out.println("Phrase reverse: " + reverseCharString(phraseInput));

        //pyramide
        System.out.println("Entrez hauteur de pyramide: ");
        Scanner scannerHeight = new Scanner(System.in);
        int heightInput = scannerHeight.nextInt();
        pyramidString(heightInput);

        //Rectangles
        System.out.println("----Rectangles---calcul d'aire---");
        Rectangle rectangle = new Rectangle(7,5);
        rectangle.display();

        Square square = new Square(11, 3);
        square.display();
        System.out.println("Calcul d'aire, x*y: " + square.squareCalcul());

        //Somme des nombres jusqu’à 10 000
        System.out.println("Somme des nombres jusqu’à 10 000: " + numberSum(10000));

        //Nombre Pair/impair/premier
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ecrire un nombre: ");
        int nombre = scanner.nextInt();
        System.out.println("Ce nombre " + nombre + " est "+ detailsNumber(nombre)+ " et " + checkFirstNumber(nombre));

        //Trouver nombre aleatoire
        findRandomNumber();

        //phrase : trouver le nombre de mots
        Scanner scannerPhrase2 = new Scanner(System.in);
        System.out.println("Ecrire une phrase: ");
        String phraseInput2 = scannerPhrase2.nextLine();

        Exo3h exo3h = new Exo3h(phraseInput2);
        System.out.println("Nombre de mots dans la phrase: " + exo3h.countWordsInPhrase(phraseInput2));

        //creation du fichier texte avec la phrase dedans
        exo3h.createTextFile();

        //lire un fichier texte
        Scanner scannerReadFromFile = new Scanner(System.in);
        System.out.println("Chemin absolu du fichier texte a lire:");
        String pathTextFileInput = scannerReadFromFile.nextLine();
        exo3h.readTextFile(pathTextFileInput);

        //Compte bancaire, jeu de class
        Customer customer1 = new Customer("Dupont", 100);
        CustomerService customerService1 = new CustomerService(customer1);
        customer1.setEmail("lolo@ipi.net");
        customer1.setFirstname("Laurent");
        System.out.println("Client 1: " + customer1.getFirstname() + " " + customer1.getLastname() + " " + customer1.getSold());
        customerService1.addMoney(540);
        customerService1.takeMoney(30);
        System.out.println("Client 1: " + customer1.getFirstname() + " " + customer1.getLastname() + " " + customer1.getSold());

        SingletonMemoryAddress singletonMemoryAddress = SingletonMemoryAddress.getlnstance();
        singletonMemoryAddress.memoryAddress();
        SingletonMemoryAddress singletonMemoryAddress2 = SingletonMemoryAddress.getlnstance();
        SingletonMemoryAddress singletonMemoryAddress3 = SingletonMemoryAddress.getlnstance();

        if (singletonMemoryAddress == singletonMemoryAddress2 && singletonMemoryAddress2 == singletonMemoryAddress3) {
            System.out.println("Singleton pattern fonctionne");
        } else {
            System.out.println("Singleton pattern oups");
        }

        CustomerController customerController = new CustomerController();
        customerController.playMenu();
    }

    /**
     * Reverse the chart of an input string
     * @param textInput
     * @return
     */
    public static StringBuilder reverseCharString(String textInput) {
        StringBuilder textSB = new StringBuilder(textInput);
        return textSB.reverse();
    }

    /**
     * Create a pyramid of "A" where 1 level = 1 height
     * @param height
     */
    public static void pyramidString(int height) {
        String textToPrint = "";
        int countRepeatSpace = height;
        for(int i = 1; i <= height; i++) {
            countRepeatSpace--;
            String spaceBeforeString = " ";
            if (i==1){
                textToPrint = "A";
            } else {
                textToPrint = textToPrint + "AA";
            }
            System.out.println(spaceBeforeString.repeat(countRepeatSpace) + textToPrint);
        }
    }

    /**
     * Sum of the numbers from a number
     * @param inputNumber
     * @return
     */
    public static int numberSum(int inputNumber){
        int countInputNumber = 0;
        for(int i = 0; i <= inputNumber; i++){
            countInputNumber = countInputNumber + i;
        }
        return countInputNumber;
    }

    /**
     * Check if a number is even or not, and if it is a first number
     * @param inputNumber
     * @return
     */
    public static String detailsNumber(int inputNumber) {
        String detailsOfTheNumber = "";
        if (inputNumber % 2 == 0) {
            detailsOfTheNumber = "pair";
        }
        else {
            detailsOfTheNumber = "impair";
        }
        return detailsOfTheNumber;
    }

    private static String checkFirstNumber(int inputNumber) {
        String checkedFirstNumber = "";
        int reste;
        boolean flag = true;

        for(int i=2; i <= inputNumber/2; i++)
        {
            reste = inputNumber%i;
            if(reste == 0)
            {
                flag = false;
                break;
            }
        }
        if(flag)
            checkedFirstNumber = "est un nombre premier";
        else
            checkedFirstNumber = "n'est pas un nombre premier";
        return checkedFirstNumber;
    }

    /**
     * Little game for the user to find a random number
     */
    public static void findRandomNumber() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int countedTries = 1;
        int maxCountedTries = 10;
        int computerRandomNumber = 1 + random.nextInt(99); //borneInf+random.nextInt(borneSup-borneInf);

        System.out.println("Devinez un nombre entre 1 et 100: ");
        Integer userNumberInt = 0;

        while((computerRandomNumber != userNumberInt) & ((countedTries) < maxCountedTries)) {
            System.out.println("Tapez un nombre: ");
            try{
                String userNumber = scanner.nextLine();
                userNumberInt = Integer.parseInt(userNumber);

                countedTries = countedTries + 1;
                if (userNumberInt < computerRandomNumber) {
                    System.out.println("Nombre trop petit");
                } else if (userNumberInt > computerRandomNumber){
                    System.out.println("Nombre trop grand");
                }
            }
            catch (NumberFormatException e){
                System.out.println("Ceci n'est pas un nombre!");
            }
        }

        if (countedTries >= maxCountedTries){
            System.out.println("Perdu! Tu as atteint le nombre max de coups, le nombre était " + computerRandomNumber);
        } else {
            System.out.println("Bingo! Trouvé en "+countedTries+" coups!");
        }
    }

}
