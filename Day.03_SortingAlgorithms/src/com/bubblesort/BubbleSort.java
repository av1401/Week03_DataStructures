package com.bubblesort;

public class BubbleSort {

    //Apply Bubble sort
    public static void bubbleSort(int array[]) {
        //check whether swaps are done or not
        boolean swapped = false;
        //iterate through array
        for(int i =0 ; i< array.length -1 ; i++){
            //iterate through array to swap the elements
            for(int j=0; j<array.length -1 - i; j++){
                //swap if current element is greater than the next element
                if(array[j] > array[j+1] ){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }
    }

    public static void main(String[] args) {
        //Create an array that contains marks of multiple students
        int studentMarks[] = {97,64,87,89,74,78,68,63,88};
        //print the original array
        System.out.print("Original array : ");
        for(int i = 0; i < studentMarks.length; i++){
            System.out.print(studentMarks[i] + " ");
        }
        bubbleSort(studentMarks);
        System.out.println();
        //print the sorted array
        System.out.print("Array after Sorting : ");
        for(int i = 0; i < studentMarks.length; i++){
            System.out.print(studentMarks[i] + " ");
        }
    }

}
