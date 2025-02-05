package com.stringbuilder.problem1;

public class ReverseString {
    //Method to reverse string using string builder
    public static String reversedString(String string){
        StringBuilder builder = new StringBuilder(); // Create a string builder
        builder.append(string); // append string in string builder
        builder.reverse(); //reverse the string builder
        string = builder.toString(); // reconvert to string
        return string;
    }
    public static void main(String[] args) {
        String string = "Hello";
        System.out.println("Original String : " + string);
        System.out.print("Reversed String : " + reversedString(string));
    }
}

