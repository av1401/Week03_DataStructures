package com.stackandqueue.problem2;

import java.util.Stack;

public class SortUsingRecursion {

    // Recursive method to sort a stack
    public static void sortStack(Stack<Integer> stack) {
        // Base case: If stack has only one element, it is already sorted
        if (stack.size() <= 1) {
            return;
        }

        // Step 1: Remove the top element
        int top = stack.pop();

        // Step 2: Recursively sort the remaining stack
        sortStack(stack);

        // Step 3: Insert the popped element back in the correct position
        insertInSortedOrder(stack, top);
    }

    // Helper method to insert an element in the sorted stack
    private static void insertInSortedOrder(Stack<Integer> stack, int element) {
        // Base case: If the stack is empty or the element is greater than the top of the stack
        if (stack.isEmpty() || element >= stack.peek()) {
            stack.push(element);
            return;
        }

        // Step 1: Remove the top element
        int top = stack.pop();

        // Step 2: Recursively insert the element into the sorted stack
        insertInSortedOrder(stack, element);

        // Step 3: Push the top element back after inserting the element
        stack.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        System.out.println("Original stack: " + stack);

        sortStack(stack);

        System.out.println("Sorted stack: " + stack);
    }
}

