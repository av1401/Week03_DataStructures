package com.problem1;

import java.util.Arrays;
import java.util.Random;

public class SearchTarget {

    public static double LinearSearch(int[] numbers, int target) {
        // Performing linear search and checking the time taken by it
        long startTime = System.nanoTime();
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == target) {
                System.out.println("Found " + target + " at index " + i + " using Linear Search");
                break;
            }
        }
        long endTime = System.nanoTime();
        return (endTime - startTime)/1e6; // Return time taken by linear search
    }

    public static double BinarySearch(int[] numbers, int target) {
        // Performing binary search and checking the time taken by it
        long startTime = System.nanoTime();
        int left = 0, right = numbers.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] == target) {
                System.out.println("Found " + target + " at index " + mid + " using Binary Search");
                break;
            } else if (numbers[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        long endTime = System.nanoTime();
        return (endTime - startTime)/1e6; // Return time taken by binary search
    }

    public static void compare(double timeLinear, double timeBinary) {
        System.out.println("Comparison of Search Algorithms:");
        System.out.println("Time taken by Linear Search: " + timeLinear + " ms");
        System.out.println("Time taken by Binary Search: " + timeBinary + " ms");

        if (timeLinear < timeBinary) {
            System.out.println("Linear Search was faster.");
        } else if (timeBinary < timeLinear) {
            System.out.println("Binary Search was faster.");
        } else {
            System.out.println("Both took the same time.");
        }
        System.out.println("--------------------------------------");
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};
        Random random = new Random();

        for (int N : sizes) {
            int[] arr = new int[N];

            // Fill array with random values
            for (int i = 0; i < N; i++) {
                arr[i] = random.nextInt(N);
            }
            int target = 500;

            double timeLinear1 = LinearSearch(arr, target);
            Arrays.sort(arr);
            double timeBinary1 = BinarySearch(arr, target);
            compare(timeLinear1, timeBinary1);
        }
    }
}
