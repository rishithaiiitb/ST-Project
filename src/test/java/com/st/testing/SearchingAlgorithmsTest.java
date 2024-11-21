package com.st.testing;

import org.junit.Test;
import static org.junit.Assert.*;

public class SearchingAlgorithmsTest {

    // Linear Search
    @Test
    public void testLinearSearchPositive() {
        int[] arr = {};
        assertEquals(-1, SearchingAlgorithms.linearSearch(arr, 5));

        int[] arr1 = {-9, 3, 5, -7};
        assertEquals(3, SearchingAlgorithms.linearSearch(arr1, -7));

        int[] arr2 = {36, 24, 12, 48};
        assertEquals(2, SearchingAlgorithms.linearSearch(arr2, 12));
    }

    @Test
    public void testLinearSearchNegative() {
        int[] arr1 = {8, 4, 15, 16};
        assertNotEquals(3, SearchingAlgorithms.linearSearch(arr1, 15));

        int[] arr2 = {25, 5, 10, -20};
        assertNotEquals(2, SearchingAlgorithms.linearSearch(arr2, 25));
    }

    // Binary Search
    @Test
    public void testBinarySearchPositive() {
        int[] arr1 = {7, 8, 9, 15, 23};
        assertEquals(4, SearchingAlgorithms.binarySearch(arr1, 23));

        int[] arr2 = {-40, -30, 20, 50};
        assertEquals(-1, SearchingAlgorithms.binarySearch(arr2, 30));
    }

    @Test
    public void testBinarySearchNegative() {
        int[] arr1 = {10, 45, 102, 600, 988};
        assertNotEquals(4, SearchingAlgorithms.binarySearch(arr1, 600));

        int[] arr2 = {52, 69, 73, 86};
        assertNotEquals(1, SearchingAlgorithms.binarySearch(arr2, 52));
    }

    // Hashing Search
    @Test
    public void testHashingSearchPositive() {
        int[] arr1 = {9, 2, 6, 4};
        assertTrue(SearchingAlgorithms.hashingSearch(arr1, 4));

        int[] arr2 = {44, 22, 11, 33};
        assertTrue(SearchingAlgorithms.hashingSearch(arr2, 44));
    }

    @Test
    public void testHashingSearchNegative() {
        int[] arr1 = {1, 9, 3, -7};
        assertFalse(SearchingAlgorithms.hashingSearch(arr1, 8));

        int[] arr2 = {56, -14, 42, 28};
        assertFalse(SearchingAlgorithms.hashingSearch(arr2, 29));
    }

    // Tree Based Search
    @Test
    public void testTreeSearchPositive() {
        int[] arr1 = {3, 1, 4, 2, 5};
        assertTrue(SearchingAlgorithms.treeSearch(arr1, 4));

        int[] arr2 = {10, 5, 20, 15, 30};
        assertTrue(SearchingAlgorithms.treeSearch(arr2, 15));
    }

    @Test
    public void testTreeSearchNegative() {
        int[] arr = {3, -1, 4, -2, 5};
        assertFalse(SearchingAlgorithms.treeSearch(arr, 6));

        int[] arr1 = {10, 5, 20, 15, 30};
        assertFalse(SearchingAlgorithms.treeSearch(arr1, 25));

        int[] arr2 = {5, 5, 5, 5};
        assertFalse(SearchingAlgorithms.treeSearch(arr2, 6));
    }

    // Fibonacci Search
    @Test
    public void testFibonacciSearchPositive() {
        int[] arr1 = {-5, 10, 15, 20, 25};
        assertEquals(2, SearchingAlgorithms.fibonacciSearch(arr1, 15));

        int[] arr2 = {7, 14, 21, 28};
        assertEquals(3, SearchingAlgorithms.fibonacciSearch(arr2, 28));

        int[] arr3 = {1, 10, 6, 27};
        assertEquals(-1, SearchingAlgorithms.fibonacciSearch(arr3, 56));
    }

    @Test
    public void testFibonacciSearchNegative() {
        int[] arr = {10};
        assertNotEquals(1, SearchingAlgorithms.fibonacciSearch(arr, 10));

        int[] arr1 = {5, 1, 2, 3, 4};
        assertNotEquals(4, SearchingAlgorithms.fibonacciSearch(arr1, 2));

        int[] arr2 = {32, 8, 24, 16};
        assertNotEquals(1, SearchingAlgorithms.fibonacciSearch(arr2, 32));

        int[] arr3 = {-15, -10, -5, 0, 5, 10};
        assertNotEquals(4, SearchingAlgorithms.fibonacciSearch(arr3, -20));
    }
}
