package com.st.testing;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotEquals;

public class SortingAlgorithmsTest {

    // Selection Sort
    @Test
    public void testSelectionSortPositive() {
        int[] arr1 = {5, 2, 9, 1, 5, 6};
        SortingAlgorithms.selectionSort(arr1);
        assertArrayEquals(new int[]{1, 2, 5, 5, 6, 9}, arr1);

        int[] arr2 = {10, 9, 8, -7, -6};
        SortingAlgorithms.selectionSort(arr2);
        assertArrayEquals(new int[]{-7, -6, 8, 9, 10}, arr2);

        int[] arr3 = {-1, -1, 5, -2, -2};
        SortingAlgorithms.selectionSort(arr3);
        assertArrayEquals(new int[]{-2, -2, -1, -1, 5}, arr3);
    }

    @Test
    public void testSelectionSortNegative() {
        int[] arr1 = {1, 2, 3, 4, -5};
        SortingAlgorithms.selectionSort(arr1);
        assertNotEquals(new int[]{-5, 1, 2, 3, 4}, arr1);

        int[] arr2 = {100, 50, -25, 12, 0};
        SortingAlgorithms.selectionSort(arr2);
        assertNotEquals(new int[]{0, -25, 12, 50, 100}, arr2);
    }

    // Bubble Sort
    @Test
    public void testBubbleSortPositive() {
        int[] arr1 = {9, -7, 5, 11, 1};
        SortingAlgorithms.bubbleSort(arr1);
        assertArrayEquals(new int[]{-7, 1, 5, 9, 11}, arr1);

        int[] arr2 = {12, 12, -12, 12};
        SortingAlgorithms.bubbleSort(arr2);
        assertArrayEquals(new int[]{-12, 12, 12, 12}, arr2);
    }

    @Test
    public void testBubbleSortNegative() {
        int[] arr1 = {0, -1, -5, 2, 9, 8};
        SortingAlgorithms.bubbleSort(arr1);
        assertNotEquals(new int[]{-5, -1, 0, 2, 9, 8}, arr1);

        int[] arr2 = {5, 1, 2, -6};
        SortingAlgorithms.bubbleSort(arr2);
        assertNotEquals(new int[]{-6, 1, 2, 5}, arr2);

        int[] arr3 = {};
        SortingAlgorithms.bubbleSort(arr3);
        assertNotEquals(new int[]{8}, arr3);
    }

    // Insertion Sort
    @Test
    public void testInsertionSortPositive() {
        int[] arr1 = {3, -2, 1};
        SortingAlgorithms.insertionSort(arr1);
        assertArrayEquals(new int[]{-2, 1, 3}, arr1);

        int[] arr2 = {100, -50, 25, -12};
        SortingAlgorithms.insertionSort(arr2);
        assertArrayEquals(new int[]{-50, -12, 25, 100}, arr2);

        int[] arr3 = {-5, -4, 4, 5};
        SortingAlgorithms.insertionSort(arr3);
        assertArrayEquals(new int[]{-5, -4, 4, 5}, arr3);
    }

    @Test
    public void testInsertionSortNegative() {
        int[] arr1 = {7, 2, 9, 6, -1, 4};
        SortingAlgorithms.insertionSort(arr1);
        assertNotEquals(new int[]{-1, 2, 3, 4, 5, 6}, arr1);

        int[] arr2 = {9, 7, -5};
        SortingAlgorithms.insertionSort(arr2);
        assertNotEquals(new int[]{-5, 7, 9}, arr2);
    }

    // Merge Sort
    @Test
    public void testMergeSortPositive() {
        int[] arr1 = {6, 3, -2, 7, 1, 5};
        SortingAlgorithms.mergeSort(arr1);
        assertArrayEquals(new int[]{-2, 1, 3, 5, 6, 7}, arr1);

        int[] arr2 = {8, 4, 7, -3, 5, 1};
        SortingAlgorithms.mergeSort(arr2);
        assertArrayEquals(new int[]{-3, 1, 4, 5, 7, 8}, arr2);
    }

    @Test
    public void testMergeSortNegative() {
        int[] arr1 = {9, 7, 4, 6, -2, 1};
        SortingAlgorithms.mergeSort(arr1);
        assertNotEquals(new int[]{-2, 4, 6, 7, 9, 1}, arr1);

        int[] arr2 = {5, 3, -8, 6};
        SortingAlgorithms.mergeSort(arr2);
        assertNotEquals(new int[]{-8, 3, 5, 6}, arr2);
    }

    // Quick Sort
    @Test
    public void testQuickSortPositive() {
        int[] arr1 = {9, -4, 2, 8, 5, 1};
        SortingAlgorithms.quickSort(arr1);
        assertArrayEquals(new int[]{-4, 1, 2, 5, 8, 9}, arr1);

        int[] arr2 = {3, -1, 4, 1, 5, 9, 2, 6, -5};
        SortingAlgorithms.quickSort(arr2);
        assertArrayEquals(new int[]{-5, -1, 1, 2, 3, 4, 5, 6, 9}, arr2);
    }

    @Test
    public void testQuickSortNegative() {
        int[] arr1 = {2, 3, 1};
        SortingAlgorithms.quickSort(arr1);
        assertNotEquals(new int[]{3, 2, 1}, arr1);

        int[] arr2 = {1, -4, 5, 2};
        SortingAlgorithms.quickSort(arr2);
        assertNotEquals(new int[]{-4, 1, 2, 5}, arr2);

        int[] arr3 = {5, 5, 5};
        SortingAlgorithms.quickSort(arr3);
        assertNotEquals(new int[]{5, 5, 7}, arr3);
    }

    // Heap Sort
    @Test
    public void testHeapSortPositive() {
        int[] arr1 = {4, 10, 3, 5, -1};
        SortingAlgorithms.heapSort(arr1);
        assertArrayEquals(new int[]{-1, 3, 4, 5, 10}, arr1);

        int[] arr2 = {9, -7, 5, 11, 1};
        SortingAlgorithms.heapSort(arr2);
        assertArrayEquals(new int[]{-7, 1, 5, 9, 11}, arr2);
    }

    @Test
    public void testHeapSortNegative() {
        int[] arr1 = {12, 10, 9, 5, -8};
        SortingAlgorithms.heapSort(arr1);
        assertNotEquals(new int[]{-8, 9, 5, 12, 10}, arr1);

        int[] arr2 = {4, 1, 2, -7};
        SortingAlgorithms.heapSort(arr2);
        assertNotEquals(new int[]{-7, 1, 2, 4}, arr2);
    }

    // Radix Sort
    @Test
    public void testRadixSortPositive() {
        int[] arr1 = {4, 3, 2, 5, 1};
        SortingAlgorithms.radixSort(arr1);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr1);

        int[] arr2 = {12, 4, 5, 7};
        SortingAlgorithms.radixSort(arr2);
        assertArrayEquals(new int[]{4, 5, 7, 12}, arr2);

        int[] arr3 = {5};
        SortingAlgorithms.radixSort(arr3);
        assertArrayEquals(new int[]{5}, arr3);
    }

    @Test
    public void testRadixSortNegative() {
        int[] arr1 = {10, 7, 2, 3};
        SortingAlgorithms.radixSort(arr1);
        assertNotEquals(new int[]{2, 3, 7, 10}, arr1);

        int[] arr2 = {2, 4, 3};
        SortingAlgorithms.radixSort(arr2);
        assertNotEquals(new int[]{2, 3, 4}, arr2);
    }


    // Counting Sort
    @Test
    public void testCountingSortPositive() {
        int[] arr1 = {1, 2, 2, 1, 3, 0};
        SortingAlgorithms.countingSort(arr1);
        assertArrayEquals(new int[]{0, 1, 1, 2, 2, 3}, arr1);

        int[] arr2 = {5, 5, 3, 8, 7};
        SortingAlgorithms.countingSort(arr2);
        assertArrayEquals(new int[]{3, 5, 5, 7, 8}, arr2);

        int[] arr3 = {0};
        SortingAlgorithms.countingSort(arr3);
        assertArrayEquals(new int[]{0}, arr3);
    }

    @Test
    public void testCountingSortNegative() {
        int[] arr1 = {10, 7, 5, 3};
        SortingAlgorithms.countingSort(arr1);
        assertNotEquals(new int[]{3, 5, 7, 10}, arr1);

        int[] arr2 = {2, 4, 1};
        SortingAlgorithms.countingSort(arr2);
        assertNotEquals(new int[]{1, 2, 4}, arr2);
    }

    // Bucket Sort
    @Test
    public void testBucketSortPositive() {
        int[] arr1 = {42, 32, 23, 34, 35};
        SortingAlgorithms.bucketSort(arr1);
        assertArrayEquals(new int[]{23, 32, 34, 35, 42}, arr1);

        int[] arr2 = {9, 7, 1, 4, 6};
        SortingAlgorithms.bucketSort(arr2);
        assertArrayEquals(new int[]{1, 4, 6, 7, 9}, arr2);
    }

    @Test
    public void testBucketSortNegative() {
        int[] arr1 = {5, 3, 1, 7};
        SortingAlgorithms.bucketSort(arr1);
        assertNotEquals(new int[]{1, 3, 5, 7}, arr1);

        int[] arr2 = {2, 9, 8};
        SortingAlgorithms.bucketSort(arr2);
        assertNotEquals(new int[]{2, 8, 9}, arr2);

        int[] arr3 = {};
        SortingAlgorithms.bucketSort(arr3);
        assertNotEquals(new int[]{1}, arr3);
    }
}
