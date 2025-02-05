package com.linearsearch.problem2;

public class SearchWord {

    public static void findWord(String[] sentences, String targetWord) {
        for(String sentence : sentences) {
            String[] words = sentence.split(" ");
            for (String word : words) {
                if (word.equals(targetWord)) {  // Compare each word with the targetWord
                    System.out.println("Sentence containing target word: " + sentence);
                    return;  // Stop after finding the word
                }
            }
        }
        System.out.println("Target word not found");
    }
    public static void main(String[] args) {
        String[] sentences = {"Hello how are you" , "I am a java user." , "But i believe python is much better than java,", "python is much easier and better."};
        String targetWord = "python";
        findWord(sentences, targetWord);
    }
}
