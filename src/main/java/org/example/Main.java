package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static String textInput="Hello world!";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ecrire un nombre: ");

        int nombre = scanner.nextInt();
        System.out.println("Ce nombre " + nombre + " est "+ typeNombre(nombre)+ " et " + checkNbrePremier(nombre));

        System.out.println("Input: " + textInput);
        System.out.println("String reverse: " + reverseCaractString(textInput));
        pyramideString(textInput);
        System.out.println("Somme des nombres: " + calculSommeNbres(10000));
        findNombreAleatoire();
    }

    public static StringBuilder reverseCaractString(String textInput) {
        StringBuilder textSB = new StringBuilder(textInput);
        return textSB.reverse();
    }

    public static void pyramideString(String textInput) {
        String tableauString [] = new String[textInput.length()];
        textInput = textInput.replaceAll("\\s", "");
        String textToPrint = "";
        for(int i = 0; i < textInput.length(); i++) {
            char charToPrint = textInput.charAt(i);
            textToPrint = textToPrint + charToPrint;
            System.out.println(textToPrint);
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

    public static void findNombreAleatoire() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int nbreCoups = 1;
        int nbreCoupsMax = 10;
        int nbreAleatoire ;
        nbreAleatoire = random.nextInt(100); //borneInf+random.nextInt(borneSup-borneInf);

        System.out.println("Ecrire un nombre entre 0 et 100: " + nbreAleatoire);
        int nombreUser = scanner.nextInt();
        while((nbreAleatoire != nombreUser) & (nbreCoups <= nbreCoupsMax)) {
            nbreCoups = nbreCoups + 1;
            if (nombreUser < nbreAleatoire) {
                System.out.println("Nombre trop petit");
            } else {
                System.out.println("Nombre trop grand");
            }

            nombreUser = scanner.nextInt();
        }
        if (nbreCoups > nbreCoupsMax){
            System.out.println("Perdu! Tu as atteint le nombre max de coups!");
        } else {
            System.out.println("Bingo! Trouvé en "+nbreCoups+" coups!");
        }
    }



}