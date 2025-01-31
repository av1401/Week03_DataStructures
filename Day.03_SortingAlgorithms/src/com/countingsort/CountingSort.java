package com.countingsort;

import java.util.Arrays;

public class CountingSort {

    public static void countingSort(int[] arr) {
        // Find the maximum value in the array
        int max = Arrays.stream(arr).max().getAsInt();

        //Create and populate the count array
        int[] count = new int[max + 1];
        for (int num : arr) {
            count[num]++;
        }

        //Calculate the cumulative frequency
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        //Place elements into the sorted array
        int[] sorted = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            sorted[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--; // Decrement the count for the placed element
        }

        // Copy sorted elements back to the original array
        System.arraycopy(sorted, 0, arr, 0, arr.length);
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 8, 3, 3, 1};
        System.out.println("Original Array: " + Arrays.toString(arr));

        countingSort(arr);

        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
}

