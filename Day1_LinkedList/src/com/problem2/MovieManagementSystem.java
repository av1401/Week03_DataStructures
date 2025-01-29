package com.problem2;

// Class representing a single Movie node in the doubly linked list
class Movie {
    String movieTitle;
    String directorName;
    String releaseYear;
    double rating;
    Movie next;
    Movie prev;

    // Constructor to initialize movie details
    Movie(String movieTitle, String directorName, String releaseYear, double rating) {
        this.movieTitle = movieTitle;
        this.directorName = directorName;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

// Class representing the Movie Linked List
class MovieLinkedList {
    Movie head, tail; // Head and tail pointers for the doubly linked list

    // Add a movie at the beginning of the list
    public void addAtBeginning(String movieTitle, String directorName, String releaseYear, double rating) {
        Movie newMovie = new Movie(movieTitle, directorName, releaseYear, rating);
        if (head == null) { // If the list is empty, head and tail point to the new movie
            head = newMovie;
            tail = newMovie;
            return;
        }
        newMovie.next = head;  // Point the new movie to the current head
        head.prev = newMovie;  // Set previous of current head to the new movie
        head = newMovie;       // Update the head to the new movie
    }

    // Add a movie at the end of the list
    public void addAtEnd(String movieTitle, String directorName, String releaseYear, double rating) {
        Movie newMovie = new Movie(movieTitle, directorName, releaseYear, rating);
        if (head == null) { // If the list is empty, head and tail point to the new movie
            head = newMovie;
            tail = newMovie;
            return;
        }
        tail.next = newMovie;  // Point the current tail to the new movie
        newMovie.prev = tail;  // Set previous of the new movie to the current tail
        tail = newMovie;       // Update the tail to the new movie
    }

    // Add a movie at a specific position in the list
    public void addAtSpecificPosition(int position, String movieTitle, String directorName, String releaseYear, double rating) {
        if (position <= 0) { // Invalid position check
            System.out.println("Invalid Position.");
            return;
        }
        Movie newMovie = new Movie(movieTitle, directorName, releaseYear, rating);
        if (position == 1) { // If adding at the first position
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
            return;
        }
        Movie current = head;
        // Traverse the list to find the position
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null) { // If the position is out of bounds
            System.out.println("Position is Out of Bound.");
            return;
        }
        newMovie.next = current.next; // Link the new movie in the correct position
        if (current.next != null) {
            current.next.prev = newMovie;
        } else {
            tail = newMovie; // Update the tail if adding at the end
        }
        newMovie.prev = current;
        current.next = newMovie;
    }

    // Remove a movie by its title
    public void removeMovieByTitle(String movieTitle) {
        if (head == null) { // Check if the list is empty
            System.out.println("List is Empty.");
            return;
        }
        Movie current = head;
        // Traverse the list to find the movie
        while (current.next != null && !current.movieTitle.equalsIgnoreCase(movieTitle)) {
            current = current.next;
        }
        if (current.prev != null) { // If the movie is not the head
            current.prev.next = current.next;
        } else {
            head = current.next; // Update the head if the movie is at the beginning
        }
        if (current.next != null) { // If the movie is not the tail
            current.next.prev = current.prev;
        } else {
            tail = current.prev; // Update the tail if the movie is at the end
        }
        System.out.println(current.movieTitle + " is Deleted from list.");
    }

    // Search for a movie by director name
    public void searchByDirector(String directorName) {
        if (head == null) { // Check if the list is empty
            System.out.println("List is Empty.");
            return;
        }
        Movie current = head;
        // Traverse the list to find the director
        while (current != null && !directorName.equalsIgnoreCase(current.directorName)) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Movie is not present in list.");
        } else {
            System.out.println("Movie Name: " + current.movieTitle);
            System.out.println("Release Year: " + current.releaseYear);
        }
    }

    // Search for a movie by rating
    public void searchByRating(double rating) {
        if (head == null) { // Check if the list is empty
            System.out.println("List is Empty.");
            return;
        }
        Movie current = head;
        // Traverse the list to find the movie by rating
        while (current != null && rating != current.rating) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Movie is not present in list.");
        } else {
            System.out.println("Movie Name: " + current.movieTitle);
            System.out.println("Release Year: " + current.releaseYear);
        }
    }

    // Print movies in forward order
    public void printForward() {
        if (head == null) { // Check if the list is empty
            System.out.println("List is Empty.");
            return;
        }
        System.out.println("\nPrinting Movie in Forward order.\n");
        Movie current = head;
        // Traverse the list and print each movie
        while (current != null) {
            System.out.println("Movie Name: " + current.movieTitle);
            System.out.println("Release Year: " + current.releaseYear);
            System.out.println("Director: " + current.directorName);
            System.out.println("Rating: " + current.rating);
            current = current.next;
            System.out.println();
        }
    }

    // Print movies in reverse order
    public void printReverse() {
        if (tail == null) { // Check if the list is empty
            System.out.println("List is Empty.");
            return;
        }
        Movie current = tail;
        System.out.println("Printing Movies in Reverse Order.");
        // Traverse the list in reverse and print each movie
        while (current != null) {
            System.out.println("Movie Name: " + current.movieTitle);
            System.out.println("Release Year: " + current.releaseYear);
            System.out.println("Director: " + current.directorName);
            System.out.println("Rating: " + current.rating);
            current = current.prev;
            System.out.println();
        }
    }

    // Update the rating of a movie by its title
    public void updateRating(String movieTitle, double rating) {
        if (head == null) { // Check if the list is empty
            System.out.println("List is Empty.");
            return;
        }
        Movie current = head;
        // Traverse the list to find the movie by title
        while (current != null && !current.movieTitle.equalsIgnoreCase(movieTitle)) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Movie is not present in the list.");
        } else {
            current.rating = rating; // Update the rating
            System.out.println(current.movieTitle + " rating is updated.");
        }
    }
}

// Main class to test the Movie Management System
public class MovieManagementSystem {
    public static void main(String... args) {
        MovieLinkedList movieList = new MovieLinkedList();

        // Adding movies to the list
        movieList.addAtBeginning("Avengers: Endgame", "Anthony Russo and Joe Russo", "April 26, 2019", 8.4);
        movieList.addAtEnd("Stree 2: Sarkate Ka Aatank", "Amar Kaushik", "August 15, 2024", 7.0);
        movieList.addAtSpecificPosition(2, "The Dark Knight", "Christopher Nolan", "2008", 9.0);

        // Display movies in forward and reverse order
        movieList.printForward();
        System.out.println("\n-----------------------------------");

        movieList.printReverse();

        // Update a movie's rating
        System.out.println("-------------------------------------");
        movieList.updateRating("Inception", 9.2);

        // Display movies after update
        System.out.println("---------------------------------------");
        movieList.printForward();

        // Remove a movie by title
        System.out.println();
        movieList.removeMovieByTitle("Interstellar");

        // Display movies after removal
        System.out.println("--------------------------------------------");
        movieList.printForward();
    }
}