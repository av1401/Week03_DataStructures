package com.hashmapandhashfunctions.problem2;
import java.util.HashSet;

public class GivenSumSubarray {

    public static boolean hasPairWithSum(int[] arr, int target) {
        // Create a HashSet to store visited numbers
        HashSet<Integer> seenNumbers = new HashSet<>();

        // Traverse the array
        for (int num : arr) {
            // Calculate the required number to form the target sum
            int complement = target - num;

            // Check if the complement exists in the HashSet
            if (seenNumbers.contains(complement)) {
                System.out.println("Pair found: (" + complement + ", " + num + ")");
                return true;
            }

            // Add the current number to the HashSet
            seenNumbers.add(num);
        }

        // If no pair is found
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {10, 15, 3, 7};
        int target = 17;

        if (!hasPairWithSum(arr, target)) {
            System.out.println("No pair with the given sum found.");
        }
    }
}
