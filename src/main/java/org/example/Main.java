package org.example;

import org.example.exClass.Rectangle;
import org.example.exClass.Square;
import org.example.exEntrainement.Exo3h;
import org.example.exProg.controller.AccountController;

import java.io.IOException;
import java.util.IllegalFormatException;
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
        Scanner scannerPhrase = new Scanner(System.in);
        System.out.println("Ecrire une phrase: ");
        String phraseInput2 = scannerPhrase.nextLine();

        Exo3h exo3h = new Exo3h(phraseInput2);
        System.out.println("Nombre de mots dans la phrase: " + exo3h.countWordsInPhrase(phraseInput));

        //creation du fichier texte avec la phrase dedans
        exo3h.createTextFile();

        //lire un fichier texte
        Scanner scannerReadFromFile = new Scanner(System.in);
        System.out.println("Chemin absolu du fichier texte a lire:");
        String pathTextFileInput = scannerReadFromFile.nextLine();
        exo3h.readTextFile(pathTextFileInput);

        AccountController customerController = new AccountController();
        customerController.playMenu();
    }

    public static StringBuilder reverseCharString(String textInput) {
        StringBuilder textSB = new StringBuilder(textInput);
        return textSB.reverse();
    }

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

    public static int numberSum(int inputNumber){
        int countInputNumber = 0;
        for(int i = 0; i <= inputNumber; i++){
            countInputNumber = countInputNumber + i;
        }
        return countInputNumber;
    }

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

    public static String checkFirstNumber(int inputNumber) {
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
                } else {
                    System.out.println("Nombre trop grand");
                }
            }
            catch (NumberFormatException e){
                System.out.println("Ceci n'est pas un nombre!");
            }
        }

        if (countedTries >= maxCountedTries){
            System.out.println("Perdu! Tu as atteint le nombre max de coups!");
        } else {
            System.out.println("Bingo! Trouvé en "+countedTries+" coups!");
        }
    }

}