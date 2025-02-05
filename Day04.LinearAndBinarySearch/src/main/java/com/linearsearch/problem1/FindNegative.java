package com.linearsearch.problem1;

public class FindNegative {

    //method to find first negative number
    public static int findFirstNegative(int[] array){
        //apply linear search
        for(int i =0 ;i < array.length ; i++){
            if(array[i]<0){//checks for negative number
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] array = {5,8,6,4,7,-1,5,4,-2,4,-7,9,-57,5,-4,-5,4,5};
        System.out.println(findFirstNegative(array)); // call the method
    }
}
