package com.problem1;
// Class to represent a node in the student linked list
class StudentNode {
    int rollNo;
    String name;
    int age;
    double grade;
    StudentNode next;

    // Constructor to initialize the student node
    public StudentNode(int rollNo, String name, int age, double grade) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

// Class to manage the student linked list
class StudentList {
    private static StudentNode head; // Head of the linked list

    // Method to add a student at the head of the list
    public static void addAtHead(int rollNo, String name, int age, double grade) {
        StudentNode student = new StudentNode(rollNo, name, age, grade);
        student.next = head; // Set the new student's next pointer to the current head
        head = student; // Update the head to the new student
    }

    // Method to add a student at the tail of the list
    public static void addAtTail(int rollNo, String name, int age, double grade) {
        StudentNode student = new StudentNode(rollNo, name, age, grade);

        if (head == null) { // If the list is empty, add the student as the head
            head = student;
            return;
        }

        StudentNode temp = head; // Temporary pointer to traverse the list
        while (temp.next != null) { // Traverse to the last node
            temp = temp.next;
        }

        temp.next = student; // Add the student at the end of the list
    }

    // Method to add a student at a specific position in the list
    public static void addAtSpecific(int rollNo, String name, int age, double grade, int position) {
        if (position <= 0) { // Check for valid position
            System.out.println("Invalid position! Must be greater than 0.");
            return;
        }

        StudentNode student = new StudentNode(rollNo, name, age, grade);

        if (position == 1) { // If the position is 1, add at the head
            student.next = head;
            head = student;
            System.out.println(name + " added at position " + position + ".");
            return;
        }

        StudentNode temp = head;
        int count = 1;

        // Traverse to the node just before the desired position
        while (temp != null && count < position - 1) {
            temp = temp.next;
            count++;
        }

        if (temp == null) { // If position is out of bounds, add at the end
            System.out.println("Position out of bounds! Adding at the end instead.");
            addAtTail(rollNo, name, age, grade);
        } else { // Insert the new node at the desired position
            student.next = temp.next;
            temp.next = student;
            System.out.println(name + " added at position " + position + ".");
        }
    }

    // Method to search for a student by roll number
    public static void searchBy(int rollNo) {
        if (rollNo <= 0) { // Validate roll number
            System.out.println("Please Enter a valid rollNo : ");
            return;
        }
        StudentNode temp = head;
        while (temp != null) { // Traverse the list
            if (temp.rollNo == rollNo) { // If roll number matches, display details
                System.out.println("Student Found: Roll No: " + temp.rollNo +
                        ", Name: " + temp.name +
                        ", Age: " + temp.age +
                        ", Grade: " + temp.grade);
                return;
            }
            temp = temp.next; // Move to the next node
        }
        System.out.println("Student with Roll Number " + rollNo + " not found");
    }

    // Method to delete a student by roll number
    public static void delete(int rollNo) {
        if (head == null) { // Check if the list is empty
            System.out.println("The list is empty. Cannot delete.");
            return;
        }

        // Deleting the head node
        if (head.rollNo == rollNo) {
            System.out.println("Deleting student with rollNo: " + rollNo);
            head = head.next; // Update head to the next node
            return;
        }

        // Deleting a node other than the head
        StudentNode temp = head;
        while (temp.next != null) { // Traverse the list
            if (temp.next.rollNo == rollNo) { // If the next node matches
                System.out.println("Deleting student with rollNo: " + rollNo);
                temp.next = temp.next.next; // Remove the node
                return;
            }
            temp = temp.next; // Move to the next node
        }

        System.out.println("Student with rollNo " + rollNo + " not found."); // If roll number not found
    }

    //Method to update the Grades of a student
    public static void updateGrades(int rollNo , double newGrade){

        if (head == null) { // Check if the list is empty
            System.out.println("The list is empty. Cannot delete.");
            return;
        }
        // if the head node grades needs to be change
        if (head.rollNo == rollNo) {
            System.out.println("Upgrading the grade: ");
            head.grade =  newGrade;// Update head to the next node
            return;
        }

        // updating the node other than head
        StudentNode temp = head;
        while (temp.next != null) { // Traverse the list
            if (temp.next.rollNo == rollNo) { // If the next node matches
                System.out.println("Upgrading the grade: ");
                temp.grade =  newGrade; // update the node
                return;
            }
            temp = temp.next; // Move to the next node
        }
    }

    // Method to display all student details
    public static void displayDetails() {
        if (head == null) { // Check if the list is empty
            System.out.println("The list is empty.");
            return;
        }
        StudentNode temp = head;
        System.out.println("Student List:");
        while (temp != null) { // Traverse the list and display each student's details
            System.out.println("Roll No: " + temp.rollNo + ", Name: " + temp.name +
                    ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }
}

// Main class to demonstrate the linked list functionality
public class StudentRecord {
    public static void main(String[] args) {
        // Adding students to the list
        StudentList.addAtHead(102, "Adarsh", 18, 95);
        StudentList.addAtHead(101, "Abhishek", 19, 91.4);
        StudentList.addAtTail(103, "Aman", 17, 85);
        StudentList.addAtTail(106, "Swayam", 18, 55);
        StudentList.addAtSpecific(104, "Sahil", 18, 74, 4);
        StudentList.addAtSpecific(105, "Shruti", 17, 81, 5);

        // Displaying all students
        StudentList.displayDetails();

        // Searching for a student by roll number
        StudentList.searchBy(101);

        // Deleting a student by roll number
        StudentList.delete(104);

        // Upgrading the grades
        StudentList.updateGrades(101,94);

        // Displaying the list after deletion
        StudentList.displayDetails();
    }
}
