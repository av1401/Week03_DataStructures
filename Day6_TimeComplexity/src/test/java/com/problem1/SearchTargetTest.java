package com.problem1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Random;

class SearchTargetTest {

    private int[] smallArray;
    private int[] largeArray;
    private int target;

    @BeforeEach
    void setUp() {
        Random random = new Random();
        int smallSize = 1000;
        int largeSize = 1000000;

        // Initialize arrays with random values
        smallArray = new int[smallSize];
        largeArray = new int[largeSize];

        for (int i = 0; i < smallSize; i++) {
            smallArray[i] = random.nextInt(smallSize);
        }

        for (int i = 0; i < largeSize; i++) {
            largeArray[i] = random.nextInt(largeSize);
        }

        target = 500; // Fixed target for testing
    }

    @Test
    void testLinearSearch() {
        double timeTaken = SearchTarget.LinearSearch(smallArray, target);
        assertTrue(timeTaken >= 0, "Linear search should not return negative time");
    }

    @Test
    void testBinarySearch() {
        Arrays.sort(smallArray); // Binary search requires sorted array
        double timeTaken = SearchTarget.BinarySearch(smallArray, target);
        assertTrue(timeTaken >= 0, "Binary search should not return negative time");
    }

    @Test
    void testPerformanceComparison() {
        double timeLinear = SearchTarget.LinearSearch(smallArray, target);
        Arrays.sort(smallArray);
        double timeBinary = SearchTarget.BinarySearch(smallArray, target);

        System.out.println("Linear Search Time: " + timeLinear + " ms");
        System.out.println("Binary Search Time: " + timeBinary + " ms");

        assertNotEquals(timeLinear, timeBinary, "Both searches should not take exactly the same time.");
    }

    @Test
    void testLargeArrayPerformance() {
        Arrays.sort(largeArray);
        double timeLinear = SearchTarget.LinearSearch(largeArray, target);
        double timeBinary = SearchTarget.BinarySearch(largeArray, target);

        System.out.println("Large Array Linear Search Time: " + timeLinear + " ms");
        System.out.println("Large Array Binary Search Time: " + timeBinary + " ms");

        // Binary search should be significantly faster
        assertTrue(timeBinary < timeLinear, "Binary search should be faster on a large dataset");
    }
}
