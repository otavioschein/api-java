package com.apijava.apijava.services;

import com.apijava.apijava.model.Taxi;
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

    public String listContent() {
        try {
            File file = new File("taxi.txt");
            String data = null;
            if (file.createNewFile()) {
                data = "File doesn't exist!";
                file.delete();
            } else {
                System.out.println("File exists!");
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    data = scanner.nextLine();
                    System.out.println(data);
                }
                scanner.close();
            }
            return data;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
