    package com.hashmapandhashfunctions.problem5;

    import java.util.HashMap;

    public class TwoSumProblem {

        public static int[] findTwoSum(int[] nums, int target) {
            // Create a HashMap to store numbers and their indices
            HashMap<Integer, Integer> map = new HashMap<>();

            // Iterate through the array
            for (int i = 0; i < nums.length; i++) {
                // Calculate the complement of the current number
                int complement = target - nums[i];

                // Check if the complement exists in the map
                if (map.containsKey(complement)) {
                    // Return the indices of the two numbers
                    return new int[] { map.get(complement), i };
                }

                // Add the current number and its index to the map
                map.put(nums[i], i);
            }

            // If no solution exists, throw an exception or return a default value
            throw new IllegalArgumentException("No two sum solution exists.");
        }

        public static void main(String[] args) {
            int[] nums = {51, 8, 11, 5, 4, 15};
            int target = 9;

            int[] result = findTwoSum(nums, target);

            System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
        }
    }
