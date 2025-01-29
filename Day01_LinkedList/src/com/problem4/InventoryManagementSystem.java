package com.problem4;

// Node class representing an item in the inventory
class Node {
    String itemName;
    int itemId;
    int quantity;
    double price;
    Node next;

    // Constructor to initialize the node
    public Node(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

// InventoryList class to manage the linked list of inventory items
class InventoryList {
    private static Node head; // Head pointer for the linked list

    // Method to add an item at the head of the list
    public static void addAtHead(String itemName, int itemId, int quantity, double price) {
        Node item = new Node(itemName, itemId, quantity, price);
        item.next = head; // Point the new node to the current head
        head = item;      // Update the head to the new node
    }

    // Method to add an item at the end of the list
    public static void addAtEnd(String itemName, int itemId, int quantity, double price) {
        Node item = new Node(itemName, itemId, quantity, price);

        if (head == null) { // If the list is empty
            head = item;    // Set the new node as the head
            return;
        }

        Node curr = head;
        while (curr.next != null) { // Traverse to the last node
            curr = curr.next;
        }
        curr.next = item; // Add the new node at the end
    }

    // Method to add an item at a specific position
    public static void addAtPosition(String itemName, int itemId, int quantity, double price, int position) {
        if (position < 0) { // Invalid position check
            System.out.println("Invalid position!");
            return;
        }

        Node item = new Node(itemName, itemId, quantity, price);

        if (position == 0) { // Add at the head if position is 0
            item.next = head;
            head = item;
            return;
        }

        Node curr = head;
        int count = 0;

        while (curr != null && count < position - 1) { // Traverse to the desired position
            curr = curr.next;
            count++;
        }

        if (curr == null) { // If position is out of bounds, add at the end
            System.out.println("Position out of bounds! Adding at the end.");
            addAtEnd(itemName, itemId, quantity, price);
        } else { // Insert the new node at the desired position
            item.next = curr.next;
            curr.next = item;
        }
    }

    // Method to remove an item based on its itemId
    public static void remove(int itemId) {
        if (head == null) { // If the list is empty
            System.out.println("List is empty!");
            return;
        }

        if (head.itemId == itemId) { // If the head is the node to remove
            head = head.next;
            System.out.println("Item removed with Item ID = " + itemId);
            return;
        }

        Node curr = head;
        while (curr.next != null && curr.next.itemId != itemId) { // Traverse to find the node
            curr = curr.next;
        }

        if (curr.next == null) { // If the node is not found
            System.out.println("Item with Item ID = " + itemId + " not found!");
            return;
        }

        curr.next = curr.next.next; // Remove the node
        System.out.println("Item removed with Item ID = " + itemId);
    }

    // Method to display the details of the inventory
    public static void displayDetails() {
        if (head == null) { // If the list is empty
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        System.out.println("Inventory details:");
        while (temp != null) { // Traverse the list and display details
            System.out.println("Item Name: " + temp.itemName + ", Item ID: " + temp.itemId +
                    ", Quantity: " + temp.quantity + ", Price: " + temp.price);
            temp = temp.next;
        }
    }

    // Method to calculate and display the total value of the inventory
    public static void totalValue() {
        if (head == null) { // If the list is empty
            System.out.println("List is empty list");
            return;
        }

        double totalValuePrice = 0;
        Node cur = head;

        while (cur != null) { // Traverse the list and calculate the total value
            totalValuePrice += cur.price * cur.quantity;
            cur = cur.next;
        }

        System.out.println("Total Value: " + totalValuePrice);
    }

    // Merge two sorted linked lists based on price
    private static Node mergeSortedLists(Node left, Node right) {
        if (left == null) return right; // If left list is empty
        if (right == null) return left; // If right list is empty

        Node result;
        if (left.price <= right.price) { // Compare prices
            result = left;
            result.next = mergeSortedLists(left.next, right);
        } else {
            result = right;
            result.next = mergeSortedLists(left, right.next);
        }
        return result;
    }

    // Find the middle of the linked list
    private static Node findMiddle(Node start) {
        if (start == null || start.next == null) return start;

        Node slow = start;
        Node fast = start.next;

        while (fast != null && fast.next != null) { // Move fast pointer twice as fast as slow
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Perform merge sort on the list
    public static Node mergeSort(Node start) {
        if (start == null || start.next == null) { // Base case
            return start;
        }

        Node middle = findMiddle(start);
        Node secondHalf = middle.next;
        middle.next = null;

        Node left = mergeSort(start); // Sort the left half
        Node right = mergeSort(secondHalf); // Sort the right half

        return mergeSortedLists(left, right); // Merge the two sorted halves
    }

    // Sort the inventory list using merge sort
    public static void sortInventory() {
        head = mergeSort(head);
    }
}

// Main class to test the inventory system
public class InventoryManagementSystem {
    public static void main(String[] args) {
        // Add items to the inventory
        InventoryList.addAtHead("Apple", 1, 10, 180);
        InventoryList.addAtEnd("Banana", 3, 12, 40);
        InventoryList.addAtEnd("Orange", 4, 8, 60);
        InventoryList.addAtPosition("Grapes", 2, 12, 450, 1);

        // Display inventory details
        InventoryList.displayDetails();

        // Show total value of the inventory
        InventoryList.totalValue();

        // Remove an item and display updated details
        InventoryList.remove(2);
        System.out.println("\nAfter removing item with Item ID = 2:");
        InventoryList.displayDetails();

        // Sort the inventory by price and display the sorted list
        InventoryList.sortInventory();
        System.out.println("\nAfter sorting the list based on price:");
        InventoryList.displayDetails();
    }
}
