package com.selectionsort;

public class SelectionSort {

    // Function to print the array
    public static void printArray(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
    // Function to sort the array using Selection Sort
    public static void selectionSort(int[] arr){
        //iterate over the array
        for(int i=0;i<arr.length-1;i++){
            int minimumElement = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[minimumElement]>arr[j]){
                    minimumElement = j;
                }
            }
            //swap the minimum element with the current element
            int temp = arr[minimumElement];
            arr[minimumElement] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] examScores = {64, 25, 12, 22, 11};
        System.out.print("Original Array: ");
        printArray(examScores);

        System.out.println();
        selectionSort(examScores);

        System.out.print("Sorted Array: ");
        printArray(examScores);
    }
}
