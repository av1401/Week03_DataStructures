package com.filereader.problem2;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class CountOccurence {
    public static void main(String[] args) {

        //Define the file path
        String filePath = "C:\\Users\\abhishek vishwakarma\\Desktop\\Capgemini\\Week03_DataStructures\\Day04.LinearAndBinarySearch\\src\\main\\java\\com\\FileReader\\problem2\\Sample";
        String targetWord = "of"; // provide word which you want to search
        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Read file line by line
            while ((line = br.readLine()) != null) {
                // Split the line into words
                String[] words = line.split(" ");

                // Count occurrences of the target word
                for (String word : words) {
                    // Remove punctuations
                    word = word.replace(".", "").replace(",", "").replace("!", "").replace("?", "");

                    if (word.equals(targetWord)) {
                        count++;
                    }
                }
            }
        } catch (IOException e) { // If file is not present
            System.out.println("File not found or error in reading file.");
        }

        System.out.println("The word \"" + targetWord + "\" appears " + count + " times in the file.");
    }
}
