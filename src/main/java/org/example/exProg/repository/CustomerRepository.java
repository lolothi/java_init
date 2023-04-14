package org.example.exProg.repository;

import org.example.exProg.entity.Customer;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

public class CustomerRepository {
    FileWriter file = null;
    final String pathfile = "ComptesBancaires.csv";
    JSONObject jsonObject = new JSONObject();

    public void writeJson(Customer customer) {
        String uniqueID = UUID.randomUUID().toString();
        jsonObject.put("name", customer.getLastname());
        jsonObject.put("sold", customer.getLastname());
        jsonObject.put("accountId", uniqueID);
        try{
            FileWriter file = new FileWriter("Accounts.json", true);
            file.write(jsonObject.toJSONString());
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
