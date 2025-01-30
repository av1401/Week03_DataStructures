package com.stackandqueue.problem4;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxElementInWindow {
    public static int[] maxSlidingWindow(int[] a, int k) {
        if (a == null || k <= 0) {
            return new int[0];
        }
        int n = a.length;
        int[] r = new int[n-k+1];
        int ri = 0;
        // store index
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < a.length; i++) {
            // remove numbers out of range k
            while (!q.isEmpty() && q.peekFirst() < i - k + 1) {
                q.pollFirst();
            }
            // remove smaller numbers in k range as they are useless
            while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
                q.pollLast();
            }
            // q contains index... r contains content
            q.offer(i);
            if (i >= k - 1) {
                r[ri++] = a[q.peekFirst()];
            }
        }
        return r;
    }
    //Main method for testing sliding window maximum
    public static void main(String...args){
        //Creating array
        int []arr=new int[]{7,-1,-5,-3,6,7-3,5,4,6,9};
        int k=3;//size of the window
        int []result=maxSlidingWindow(arr,k);//calling the method to find maximum at each window
        System.out.println("Maximum element of each slide: ");
        //printing the value of maximum element
        for(int num : result){
            System.out.print(num+" ");
        }

    }
}
