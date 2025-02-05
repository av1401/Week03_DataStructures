package com.challengeproblems.problem1;

import java.io.*;
public class CompareAndRead {

    public static void compare(StringBuffer buffer, StringBuilder builder) {

        String word = "hello";
        int enter = 1000000;
        long startTime = System.nanoTime(); // check time
        //input string in builder
        for (int i = 0; i < enter; i++) {
            builder.append(word);
        }
        long endTime = System.nanoTime(); // check time
        long TimeTakenByBuilder = endTime - startTime; //Calculate time taken by builder

        startTime = System.nanoTime(); // check time
        //input string in buffer
        for (int i = 0; i < enter; i++) {
            buffer.append(word);
        }
        endTime = System.nanoTime(); // check time
        long TimeTakenByBuffer = endTime - startTime; //Calculate time taken by builder

        System.out.println("Buffer takes : " + TimeTakenByBuffer + " ns");
        System.out.println("Builder takes : " + TimeTakenByBuilder + " ns\n");
        //check which one took less time
        if (TimeTakenByBuffer < TimeTakenByBuffer) {
            System.out.println("String Buffer is faster.");
            return;
        }
        System.out.println("String Builder is faster.");
    }

    public static void readAndCompare() {

        String filePath = "C:\\Users\\abhishek vishwakarma\\Desktop\\Capgemini\\Week03_DataStructures\\Day04.LinearAndBinarySearch\\src\\main\\java\\com\\challengeproblems\\problem1\\TextFile";
        int count = 0;
        long startTime, endTime;
        long timeTakenByFileReader = 0L;
        long timeTakenByInputStreamReader = 0L;

        // Measure FileReader performance
        try (FileReader fr = new FileReader(filePath)) {
            startTime = System.nanoTime();
            int i;
            while ((i = fr.read()) != -1) {
                count++;
            }
            endTime = System.nanoTime();
            timeTakenByFileReader = endTime - startTime;
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\nCount given by File Reader : " + count);
        count = 0;
        // Measure InputStreamReader performance (Without BufferedReader)
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath), "UTF-8")) {
            startTime = System.nanoTime();
            int i;
            while ((i = isr.read()) != -1) { // Directly reading characters
                count++;
            }
            endTime = System.nanoTime();
            timeTakenByInputStreamReader = endTime - startTime;
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Count given by Input Stream Reader : " + count);

        // Compare performance
        if (timeTakenByFileReader > timeTakenByInputStreamReader) {
            System.out.println("\nInputStreamReader is faster.");
        } else {
            System.out.println("\nFileReader is faster.");
        }
    }

    public static void main(String[] args) {
        StringBuffer buffer = new StringBuffer();
        StringBuilder builder = new StringBuilder();

        //call the method to compare string buffer and string builder
        compare(buffer, builder);

        //to read the word in the file and print the count of words.
        readAndCompare();
    }
}
