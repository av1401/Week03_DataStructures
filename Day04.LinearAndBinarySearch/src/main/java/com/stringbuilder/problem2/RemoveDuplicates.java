
package com.stringbuilder.problem2;

import java.util.HashSet;

public class RemoveDuplicates {
    //Method to remove duplicates
    public static String removeDuplicates(String string) {
        StringBuilder builder = new StringBuilder(); // Create a StringBuilder
        HashSet<Character> occurred = new HashSet<>();//Create a hash map
        for (char c : string.toCharArray()) {
            if (!occurred.contains(c)) { // check whether the character is in hash map or not
                builder.append(c);  // if not present add to string builder
                occurred.add(c); // then add to hash map
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String string = "MALAYALLAM";
        System.out.println("Original String : " + string);
        String result = removeDuplicates(string);
        System.out.println("String after removing duplicates: " + result);
    }
}




