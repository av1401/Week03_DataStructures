package com.problem4;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class LargeFileReaderEfficiency {

    // FileReader: Reads character by character
    private static long measureFileReaderTime(String filePath) {
        long startTime = System.currentTimeMillis();
        try (FileReader reader = new FileReader(filePath)) {
            while (reader.read() != -1) {} // Read character by character
        } catch (IOException e) {
            e.printStackTrace();
        }
        return System.currentTimeMillis() - startTime;
    }

    // InputStreamReader: Reads bytes and converts to characters
    private static long measureInputStreamReaderTime(String filePath) {
        long startTime = System.currentTimeMillis();
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8)) {
            while (reader.read() != -1) {} //
        } catch (IOException e) {
            e.printStackTrace();
        }
        return System.currentTimeMillis() - startTime;
    }

    public static void main(String[] args) {
        String filePath = "C:\\Users\\abhishek vishwakarma\\Desktop\\Capgemini\\Week03_DataStructures\\Day6_TimeComplexity\\src\\main\\java\\com\\problem4\\100mb-examplefile-com.txt"; // File Path

        long fileReaderTime = measureFileReaderTime(filePath);
        System.out.println("Time taken by FileReader: " + fileReaderTime + " ms");

        long inputStreamReaderTime = measureInputStreamReaderTime(filePath);
        System.out.println("Time taken by InputStreamReader: " + inputStreamReaderTime + " ms");

        System.out.println("\nComparison:");
        if (inputStreamReaderTime < fileReaderTime) {
            System.out.println("InputStreamReader is the fastest");
        } else {
            System.out.println("FileReader is the fastest");
        }
    }
}