package com.inputstreamreader.problem1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;


public class ByteSteamToCharacterStream {


    public static void main(String[] args) {
        //Provide path of the file
        String filePath = "C:\\Users\\abhishek vishwakarma\\Desktop\\Capgemini\\Week03_DataStructures\\Day04.LinearAndBinarySearch\\src\\main\\java\\com\\inputstreamreader\\problem1\\Sample";
        try (FileInputStream fis = new FileInputStream(filePath);
             InputStreamReader isr = new InputStreamReader(fis, "UTF-8");  // Convert bytes to characters
             BufferedReader br = new BufferedReader(isr)) {  // Read characters efficiently

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line); // Print each line
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
