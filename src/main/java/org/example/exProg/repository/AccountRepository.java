package org.example.exProg.repository;

import org.example.exProg.entity.Account;
import org.json.simple.JSONObject;

import java.io.*;
import java.util.UUID;

public class AccountRepository {

    FileWriter file = null;
    final String pathfile = "ComptesBancaires.csv";
    JSONObject jsonObject = new JSONObject();

    public void writeJson(Account account) {
        String uniqueID = UUID.randomUUID().toString();
        jsonObject.put("name", account.getName());
        jsonObject.put("sold", "0");
        jsonObject.put("accountId", uniqueID);
        try{
            FileWriter file = new FileWriter("Accounts.json", true);
            file.write(jsonObject.toJSONString());
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public String writeCSV(Account account) throws IOException {
        String uniqueID = UUID.randomUUID().toString();

        final String DELIMITER = ";";
        final String SEPARATOR = "\n";


        file = new FileWriter(pathfile, true);
        //BufferedReader br = new BufferedReader(new FileReader(pathfile));
            try
            {
                file.append("CustomerName;AccountNumber;Sold");
                file.append(SEPARATOR);

                file.append(account.getName());
                file.append(DELIMITER);
                file.append(uniqueID);
                file.append(DELIMITER);
                file.append((char) account.getSold());
                file.append(SEPARATOR);
                file.close();

            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            return "utilisateur créé";
    }

    public void findCustomer(String customerName) {
        try
        {
            File file = new File(pathfile);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            StringBuffer sb = new StringBuffer();
            String line;
            while((line = br.readLine()) != null)
            {
                // ajoute la ligne au buffer
                sb.append(line);
                sb.append("\n");
            }
            fr.close();
            System.out.println("Contenu du fichier: ");
            System.out.println(sb.toString());
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }


}
