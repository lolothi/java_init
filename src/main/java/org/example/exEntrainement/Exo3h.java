package org.example.exEntrainement;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Exo3h {
    public String phraseInput;

    public int countWords(String phraseUserInput){
        int count = 1;
        for(int i = 1; i < phraseUserInput.length(); i++) {
            if (phraseUserInput.charAt(i) == ' ' && phraseUserInput.charAt(i+1)!=' ')
            {
                count++;
            }
        }
        return count;
    }

    public void createTextFile() throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter("Files/TextFile.txt", "UTF-8");
        writer.println(phraseInput);
        writer.close();

        System.out.println("Création du fichier terminée!");
    }

    public void readTextFile(String stringPathTextFileInput) {
        Path pathTextFileInput = Paths.get(stringPathTextFileInput);
        int countWordsInFile = 0;
        try
        {
            FileInputStream file = new FileInputStream(pathTextFileInput.toFile());
            Scanner scanner = new Scanner(file);

            //verifier si nouvelles lignes a lire.
            while(scanner.hasNextLine())
            {
                String str = scanner.nextLine();
                countWordsInFile = countWordsInFile + this.countWords(str);
                System.out.println(str);
            }
            System.out.println("Nombre de mots dans le fichier:" + countWordsInFile);
            scanner.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public String getPhraseInput() {
        return phraseInput;
    }

    public void setPhraseInput(String phraseInput) {
        this.phraseInput = phraseInput;
    }

    public Exo3h(String phraseInput) {
        this.phraseInput = phraseInput;
    }
}
