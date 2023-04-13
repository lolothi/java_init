package org.example;

import org.example.exClass.Rectangle;
import org.example.exClass.Square;
import org.example.exEntrainement.Exo3h;
import org.example.exProg.controller.AccountController;

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
        System.out.println("Phrase reverse: " + reverseCaractString(phraseInput));

        //pyramide
        System.out.println("Entrez hauteur de pyramide: ");
        Scanner scannerHeight = new Scanner(System.in);
        int heightInput = scannerHeight.nextInt();
        pyramideString(heightInput);

        //Rectangles
        System.out.println("----Rectangles---calcul d'aire---");
        Rectangle rectangle = new Rectangle(7,5);
        rectangle.display();

        Square square = new Square(11, 3);
        square.display();
        System.out.println("Calcul d'aire, x*y: " + square.squareCalcul());

        //Somme des nombres jusqu’à 10 000
        System.out.println("Somme des nombres jusqu’à 10 000: " + calculSommeNbres(10000));

        //Nombre Pair/impair/premier
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ecrire un nombre: ");
        int nombre = scanner.nextInt();
        System.out.println("Ce nombre " + nombre + " est "+ typeNombre(nombre)+ " et " + checkNbrePremier(nombre));

        //Trouver nombre aleatoire
        findrandomNumber();

        //phrase : trouver le nombre de mots
        Scanner scannerPhrase = new Scanner(System.in);
        System.out.println("Ecrire une phrase: ");
        String phraseInput2 = scannerPhrase.nextLine();

        Exo3h exo3h = new Exo3h(phraseInput2);
        System.out.println("Nombre de mots dans la phrase: " + exo3h.countWords(phraseInput));

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

    public static StringBuilder reverseCaractString(String textInput) {
        StringBuilder textSB = new StringBuilder(textInput);
        return textSB.reverse();
    }

    public static void pyramideString(int height) {
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

    public static int calculSommeNbres(int NombreInput){
        int compteNombreInput = 0;
        for(int i = 0; i <= NombreInput; i++){
            compteNombreInput = compteNombreInput + i;
        }
        return compteNombreInput;
    }

    public static String typeNombre(int NombreInput) {
        String typeNombre = "";
        if (NombreInput % 2 == 0) {
            typeNombre = "pair";
        }
        else {
            typeNombre = "impair";
        }
        return typeNombre;
    }

    public static String checkNbrePremier(int NombreInput) {
        String checkedNbrePremier = "";
        int reste;
        boolean flag = true;

        for(int i=2; i <= NombreInput/2; i++)
        {
            reste = NombreInput%i;
            if(reste == 0)
            {
                flag = false;
                break;
            }
        }
        if(flag)
            checkedNbrePremier = "est un nombre premier";
        else
            checkedNbrePremier = "n'est pas un nombre premier";
        return checkedNbrePremier;
    }

    public static void findrandomNumber() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int nbreCoups = 1;
        int nbreCoupsMax = 10;
        int nbreAleatoire ;
        nbreAleatoire = random.nextInt(100); //borneInf+random.nextInt(borneSup-borneInf);

        System.out.println("Ecrire un nombre entre 0 et 100: ");
        int nombreUser = scanner.nextInt();
        while((nbreAleatoire != nombreUser) & ((nbreCoups) < nbreCoupsMax)) {
            nbreCoups = nbreCoups + 1;
            if (nombreUser < nbreAleatoire) {
                System.out.println("Nombre trop petit");
            } else {
                System.out.println("Nombre trop grand");
            }

            nombreUser = scanner.nextInt();
        }
        if (nbreCoups >= nbreCoupsMax){
            System.out.println("Perdu! Tu as atteint le nombre max de coups!");
        } else {
            System.out.println("Bingo! Trouvé en "+nbreCoups+" coups!");
        }
    }



}