package com.filereader.problem1;
import java.io.FileReader;
import java.io.IOException;

public class ReadLine {
    public static void main(String[] args) {
        try (FileReader fr = new FileReader("C:\\Users\\abhishek vishwakarma\\Desktop\\Capgemini\\Week03_DataStructures\\Day04.LinearAndBinarySearch\\src\\main\\java\\com\\FileReader\\problem1\\Text")) {
            int i;
            while ((i = fr.read()) != -1) {
                System.out.print((char) i);  // Reads and prints the file's characters
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
