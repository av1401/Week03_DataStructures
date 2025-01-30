package com.hashmapandhashfunctions.problem3;
import java.util.HashSet;

public class LongestConsecutiveSequence {

    public static int findLongestConsecutiveSequence(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        // Step 1: Add all elements to a HashSet for O(1) lookups
        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        // Step 2: Iterate through the array and check for consecutive sequences
        for (int num : nums) {
            // Only start a sequence if the current number is the beginning of a sequence
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Check for consecutive elements
                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                // Update the longest streak
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println("Longest consecutive sequence length: " + findLongestConsecutiveSequence(nums));
    }
}
