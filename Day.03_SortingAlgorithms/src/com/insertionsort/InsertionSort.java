package com.insertionsort;

public class InsertionSort {

    //Implementation of Insertion sort
    public static void InsertionSort(int array[]){
        //traverse over array
        for(int i = 1;i<array.length;i++) {
            //store the current element
            int key = array[i];
            int j = i-1;
            //check and put it int the correct position
            while(j>=0 && array[j] > key){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = key;
        }
    }

    //main function
    public static void main(String[] args) {
        //Create an array that contains employee IDs
        int employeeIds[] = {5,4,1,3,2};
        //print the original array
        System.out.print("Original array : ");
        for(int i = 0; i < employeeIds.length; i++){
            System.out.print(employeeIds[i] + " ");
        }
        System.out.println();
        //sort the array using Insertion sort
        InsertionSort(employeeIds);
        //print the sorted array
        System.out.print("Array after Sorting : ");
        for(int i = 0; i < employeeIds.length; i++){
            System.out.print(employeeIds[i] + " ");
        }
        System.out.println();
    }
}
