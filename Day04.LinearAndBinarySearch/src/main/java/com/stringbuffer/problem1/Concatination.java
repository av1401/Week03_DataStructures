package com.stringbuffer.problem1;

public class Concatination {
    public static void concatinate(String[] strings){
        StringBuffer buffer = new StringBuffer(); //create a string buffer
        for(String string : strings){ // check each string in string array
            buffer.append(string); //add the string in string buffer
            buffer.append(" "); // add a space between each string in the array
        }
        System.out.println(buffer);
    }
    public static void main(String[] args) {
        String[] strings = {"Hello" , "how" , "are" , "you", "?"}; // create a string array
        concatinate(strings);
    }
}
