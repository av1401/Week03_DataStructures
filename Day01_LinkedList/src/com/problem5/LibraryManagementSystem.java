package com.problem5;

// Class representing a book node in the doubly linked list
class Book {
    String title;
    String author;
    String genre;
    int bookID;
    boolean isAvailable;
    Book next, prev; // Pointers to the next and previous nodes in the doubly linked list

    // Constructor to initialize a book node
    public Book(String title, String author, String genre, int bookID, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookID = bookID;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}

// Class representing the Library Management System using a Doubly Linked List
class Library {
    private Book head, tail; // Pointers to the first and last books in the list
    private int count; // Tracks the total number of books in the library

    // Constructor to initialize the library
    public Library() {
        this.head = null;
        this.tail = null;
        this.count = 0;
    }

    // Add a new book at the beginning of the list
    public void addBookAtBeginning(String title, String author, String genre, int bookID, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookID, isAvailable);
        if (head == null) { // If the list is empty, set both head and tail to the new book
            head = tail = newBook;
        } else { // Otherwise, insert the new book at the beginning
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
        count++; // Increment the count of books
    }

    // Add a new book at the end of the list
    public void addBookAtEnd(String title, String author, String genre, int bookID, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookID, isAvailable);
        if (tail == null) { // If the list is empty, set both head and tail to the new book
            head = tail = newBook;
        } else { // Otherwise, append the book to the end
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
        count++;
    }

    // Add a book at a specific position (1-based index)
    public void addBookAtPosition(String title, String author, String genre, int bookID, boolean isAvailable, int position) {
        if (position < 1 || position > count + 1) { // Check for valid position
            System.out.println("Invalid position!");
            return;
        }
        if (position == 1) { // If position is the beginning, use the method to add at the beginning
            addBookAtBeginning(title, author, genre, bookID, isAvailable);
            return;
        }
        if (position == count + 1) { // If position is at the end, use the method to add at the end
            addBookAtEnd(title, author, genre, bookID, isAvailable);
            return;
        }
        // Insert the book at the specified position
        Book newBook = new Book(title, author, genre, bookID, isAvailable);
        Book temp = head;
        for (int i = 1; i < position - 1; i++) { // Traverse to the node before the desired position
            temp = temp.next;
        }
        newBook.next = temp.next;
        newBook.prev = temp;
        temp.next.prev = newBook;
        temp.next = newBook;
        count++;
    }

    // Remove a book by its Book ID
    public void removeBook(int bookID) {
        Book temp = head;
        // Traverse the list to find the book
        while (temp != null && temp.bookID != bookID) {
            temp = temp.next;
        }
        if (temp == null) { // If the book is not found
            System.out.println("Book not found!");
            return;
        }
        // Remove the book by updating pointers
        if (temp == head) { // If the book is at the head
            head = head.next;
            if (head != null) head.prev = null;
        } else if (temp == tail) { // If the book is at the tail
            tail = tail.prev;
            tail.next = null;
        } else { // If the book is in the middle
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
        count--; // Decrement the count of books
    }

    // Search for a book by Title or Author
    public void searchBook(String query) {
        Book temp = head;
        // Traverse the list to find a match
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(query) || temp.author.equalsIgnoreCase(query)) {
                System.out.println("Book Found: " + temp.title + " by " + temp.author);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found!");
    }

    // Update a book's availability status by Book ID
    public void updateAvailability(int bookID, boolean status) {
        Book temp = head;
        // Traverse the list to find the book
        while (temp != null) {
            if (temp.bookID == bookID) {
                temp.isAvailable = status; // Update the availability status
                System.out.println("Updated availability for " + temp.title);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found!");
    }

    // Display all books in forward order
    public void displayBooksForward() {
        Book temp = head;
        while (temp != null) { // Traverse the list from head to tail
            System.out.println(temp.bookID + ": " + temp.title + " by " + temp.author + " [" + (temp.isAvailable ? "Available" : "Checked Out") + "]");
            temp = temp.next;
        }
    }

    // Display all books in reverse order
    public void displayBooksReverse() {
        Book temp = tail;
        while (temp != null) { // Traverse the list from tail to head
            System.out.println(temp.bookID + ": " + temp.title + " by " + temp.author + " [" + (temp.isAvailable ? "Available" : "Checked Out") + "]");
            temp = temp.prev;
        }
    }

    // Count total books in the library
    public int countBooks() {
        return count;
    }
}

// Main class to test the library system
class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();

        // Add books to the library
        library.addBookAtBeginning("The Psychology of money of Money", "Morgon Housel", "Finance", 101, true);
        library.addBookAtEnd("Rich Dad And Poor Dad", "Mr. Kiyosaki", "Finance", 102, true);
        library.addBookAtPosition("Harry Potter", "J.K Rowlings", "Fiction", 103, false, 2);

        // Display books in forward and reverse orders
        System.out.println("Books in library (forward order):");
        library.displayBooksForward();
        System.out.println("--------------------------------------------");

        System.out.println("\nBooks in library (reverse order):");
        library.displayBooksReverse();
        System.out.println("----------------------------------------------------");

        // Search for a book and update its availability
        library.searchBook("1984");
        library.updateAvailability(103, true);

        // Display total books
        System.out.println("\nTotal books in library: " + library.countBooks());
        System.out.println("------------------------------------------------------");

        // Remove a book and display the updated list
        library.removeBook(101);
        System.out.println("\nAfter removal:");
        library.displayBooksForward();
    }
}
