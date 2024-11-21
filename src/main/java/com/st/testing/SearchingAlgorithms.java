package com.st.testing;

import java.util.*;

public class SearchingAlgorithms {

    // Linear Search
    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) return i;
        }
        return -1;
    }

    // Binary Search
    public static int binarySearch(int[] arr, int key) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == key) return mid;
            if (arr[mid] < key) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    // Hashing Search
    public static boolean hashingSearch(int[] arr, int key) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) set.add(num);
        return set.contains(key);
    }

    // Tree-Based Search (Binary Search Tree)
    public static boolean searchInTree(TreeNode root, int key) {
        while (root != null) {
            if (root.val == key) return true;
            if (key < root.val) root = root.left;
            else root = root.right;
        }
        return false;
    }

    public static boolean treeSearch(int[] arr, int key) {
        Arrays.sort(arr);
        TreeNode root = buildBinarySearchTree(arr, 0, arr.length - 1);
        return searchInTree(root, key);
    }

    private static TreeNode buildBinarySearchTree(int[] arr, int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(arr[mid]);
        node.left = buildBinarySearchTree(arr, start, mid - 1);
        node.right = buildBinarySearchTree(arr, mid + 1, end);
        return node;
    }

    // Fibonacci Search
    public static int fibonacciSearch(int[] arr, int key) {
        int n = arr.length;
        int fibM2 = 0, fibM1 = 1, fibM = fibM1 + fibM2;

        while (fibM < n) {
            fibM2 = fibM1;
            fibM1 = fibM;
            fibM = fibM1 + fibM2;
        }
        int offset = -1;
        while (fibM > 1) {
            int i = Math.min(offset + fibM2, n - 1);

            if (arr[i] < key) {
                fibM = fibM1;
                fibM1 = fibM2;
                fibM2 = fibM - fibM1;
                offset = i;
            } else if (arr[i] > key) {
                fibM = fibM2;
                fibM1 -= fibM2;
                fibM2 = fibM - fibM1;
            } else {
                return i;
            }
        }
        if (fibM1 == 1 && offset + 1 < n && arr[offset + 1] == key) {
            return offset + 1;
        }
        return -1;
    }
}
