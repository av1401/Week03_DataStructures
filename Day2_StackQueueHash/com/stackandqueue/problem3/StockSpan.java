package com.stackandqueue.problem3;

import java.util.Stack;

public class StockSpan {
    //Calculates the stock span for a given price.
    public static int spanCount(int price, Stack<int[]> spanStack) {
        int span = 1;
        // Pop elements from stack while the current price is greater than or equal to top element's price
        while (!spanStack.isEmpty() && price >= spanStack.peek()[0]) {
            span += spanStack.pop()[1]; // Accumulate span from popped elements
        }
        // Push current price and its calculated span onto the stack
        spanStack.push(new int[]{price, span});
        return span;
    }

    public static void main(String[] args) {
        int[] dayPrice = new int[]{30, 40, 25, 59, 62, 28, 39}; // Array of stock prices for consecutive days
        Stack<int[]> spanStack = new Stack<>(); // Stack to store price and span pairs

        System.out.print("Day price : ");

        for (int price : dayPrice) {
            System.out.print(price + " ");
        }
        System.out.println();

        System.out.print("Stock span : ");
        // Calculate and print stock span for each day's price
        for (int i = 0; i < dayPrice.length; i++) {
            int span = spanCount(dayPrice[i], spanStack);
            System.out.print(span + " ");
        }
    }
}
