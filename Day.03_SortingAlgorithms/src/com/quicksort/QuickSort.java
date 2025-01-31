package com.quicksort;

public class QuickSort {

    //Quick sort implementation
    public static void quickSort(int arr[], int start, int end){
        //Base case
        if(start>=end){
            return;
        }
        //find the pivot index for further applying quick sort
        int pivotIndex = partition(arr, start, end);
        quickSort(arr, start, pivotIndex-1); //apply quick sort on left side of pivot
        quickSort(arr, pivotIndex+1, end); // apply quick sort on right side of pivot
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; //takes the last element as the pivot
        int idx = low - 1;
        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot,
            // swap it with element at index 'idx' and increment 'idx'
            if (arr[j] < pivot) {
                idx++;
                int temp = arr[idx];
                arr[idx] = arr[j];
                arr[j] = temp;
            }
        }
        // Swap pivot element with element at index 'idx + 1' for right position of pivot
        int temp = arr[idx + 1];
        arr[idx + 1] = arr[high];
        arr[high] = temp;
        return idx + 1;
    }


    public static void main(String[] args) {
        int[] prices = {45,78,49,54,21,35,48};
        //Before sorting
        System.out.print("Original array : " );
        for(int i=0; i<prices.length; i++){
            System.out.print(prices[i] + " ");
        }
        System.out.println();
        //After sorting
        quickSort(prices, 0, prices.length-1);
        System.out.print("Array after sorting : " );
        for(int i=0; i<prices.length; i++){
            System.out.print(prices[i] + " ");
        }
    }
}
