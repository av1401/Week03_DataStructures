package com.inputstreamreader.problem2;

import java.io.*;

public class WriteInFile {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\abhishek vishwakarma\\Desktop\\Capgemini\\Week03_DataStructures\\Day04.LinearAndBinarySearch\\src\\main\\java\\com\\inputstreamreader\\problem2\\WriteInFile";
        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr);
             FileWriter fw = new FileWriter(filePath, true); // Append mode
             BufferedWriter bw = new BufferedWriter(fw)) {

            System.out.println("Enter text (type 'exit' to stop):");

            String line;
            while (!(line = br.readLine()).equalsIgnoreCase("exit")) {
                bw.write(line);
                bw.newLine(); // Write input as a new line in the file
            }

            System.out.println("User input saved to " + filePath);

        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
