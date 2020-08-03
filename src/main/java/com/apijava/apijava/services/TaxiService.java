package com.apijava.apijava.services;

import com.apijava.apijava.model.Taxi;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

@Service
public class TaxiService {

    public void register(Taxi taxi) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date now = new Date();
            sdf.format(now);
            taxi.setCreationTime(now);
            File file = new File("taxi.txt");
            FileWriter writer = new FileWriter("taxi.txt", true);
            if (file.createNewFile()) {
                System.out.println("Created File!");
                writer.write(taxi.toString());
            } else {
                System.out.println("File already exists!");
                writer.write(taxi.toString());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Taxi find(String nome) throws IOException {
        File file = new File("taxi.txt");
        if (file.createNewFile()) {
            System.out.println("File doesn't exist!");
            file.delete();
        } else {
            
        }
    }


}
