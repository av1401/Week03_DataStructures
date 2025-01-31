package com.mergesort;

public class MergeSort {

    public static void mergeSort(int[] arr, int si , int ei){ // si stands for starting index and ei for ending index
        if(si >= ei){
            return;
        }
        //check for the middle point
        int mid = si + (ei - si)/2;
        //call merge recursively for left and right parts
        mergeSort(arr,si,mid);
        mergeSort(arr,mid+1,ei);
        merge(arr,si,mid,ei);
    }

    public static  void merge(int[] arr, int left, int mid , int right){

        //make a temporary to perform merging
        int[] temp = new int[right - left + 1];

        int i = left; // to iterate over the left part
        int j = mid+1; // to iterate over the right part
        int k = 0; // to iterate over the temporary array

        //check for smaller element and store it in the temporary array
        while (i <= mid && j <= right) {
            if(arr[i] < arr[j]){
                temp[k] = arr[i];
                i++;
            }
            else{
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        //if elements are remaining in left part
        while(i<=mid){
            temp[k++] = arr[i++];
        }

        //if elements are remaining in right part
        while(j<=right){
            temp[k++] = arr[j++];
        }

        //copy the temporary array into the original array
        for(k=0 , i=left; k< temp.length ; k++ ,i++){
            arr[i] = temp[k];
        }
    }

    public static void main(String[] args) {
        int[] bookPrices = {143,154,187,257,344,847,124,624};
        System.out.print("Before sorting: ");
        for(int i=0; i<bookPrices.length; i++){
            System.out.print(bookPrices[i]+" ");
        }
        System.out.println();
        mergeSort(bookPrices, 0, bookPrices.length-1);
        System.out.print("After sorting: ");
        for(int i=0; i<bookPrices.length; i++){
            System.out.print(bookPrices[i]+" ");
        }
    }
}
