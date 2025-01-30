package com.stackandqueue.problem1;

import java.util.Stack;

class Queue {
    Stack<Integer> stack = new Stack<>(); // Main stack for enqueue operation
    Stack<Integer> helper = new Stack<>(); // Helper stack for dequeue operation

    //Enqueues (adds) an element to the queue.
    public void enQueue(int value) {
        stack.push(value);
    }

    //Dequeues (removes) an element from the front of the queue.
    public void deQueue() {
        if (stack.isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return;
        }
        // Transfer elements from stack to helper to reverse order
        while (!stack.isEmpty()) {
            helper.push(stack.pop());
        }
        // Remove the front element
        System.out.println("Removed Element: " + helper.pop());
        // Transfer elements back to the main stack
        while (!helper.isEmpty()) {
            stack.push(helper.pop());
        }
    }

    /**
     * Displays the elements of the queue in FIFO order.
     */
    public void display() {
        if (stack.isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        // Transfer elements to helper to print in correct order
        while (!stack.isEmpty()) {
            helper.push(stack.pop());
        }
        // Print elements and restore them back to stack
        while (!helper.isEmpty()) {
            int temp = helper.pop();
            System.out.print(temp + " ");
            stack.push(temp);
        }
    }
}

public class QueueUsingStack {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(5);
        queue.display(); // Display the queue
        queue.enQueue(7);
        queue.deQueue(); // Remove front element
        queue.display(); // Display the queue after dequeuing
    }
}
