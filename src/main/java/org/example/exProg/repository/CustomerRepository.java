package org.example.exProg.repository;

import org.example.exProg.entity.Customer;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

public class CustomerRepository {
    FileWriter file = null;
    JSONObject jsonObject = new JSONObject();

    /**
     * Write the Json file for the customers list
     * @param customer
     */
    public void writeJson(Customer customer) {
        String uniqueID = UUID.randomUUID().toString();
        jsonObject.put("name", customer.getLastname());
        jsonObject.put("sold", customer.getSold());
        jsonObject.put("accountId", uniqueID);
        try{
            FileWriter file = new FileWriter("Files/Accounts.json", true);
            file.write(jsonObject.toJSONString());
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
