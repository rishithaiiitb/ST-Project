package com.st.testing;

import java.util.ArrayList;
import java.util.List;

public class StringMatchingAlgorithms {

    public static List<Integer> naiveStringMatching(String text, String pattern) {
        List<Integer> result = new ArrayList<>();
        int n = text.length();
        int m = pattern.length();
        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) break;
            }
            if (j == m) result.add(i);
        }
        return result;
    }

    public static List<Integer> rabinKarp(String text, String pattern, int prime) {
        List<Integer> result = new ArrayList<>();

        int textLength = text.length();
        int patternLength = pattern.length();

        if (patternLength > textLength) {
            return result;
        }

        int base = 256;
        int patternHash = 0;
        int textHash = 0;
        int h = 1;

        for (int i = 0; i < patternLength - 1; i++) {
            h = (h * base) % prime;
        }

        for (int i = 0; i < patternLength; i++) {
            patternHash = (base * patternHash + pattern.charAt(i)) % prime;
            textHash = (base * textHash + text.charAt(i)) % prime;
        }

        for (int i = 0; i <= textLength - patternLength; i++) {
            if (patternHash == textHash) {
                boolean match = true;
                for (int j = 0; j < patternLength; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    result.add(i);
                }
            }

            if (i < textLength - patternLength) {
                textHash = (base * (textHash - text.charAt(i) * h) + text.charAt(i + patternLength)) % prime;

                if (textHash < 0) {
                    textHash = (textHash + prime);
                }
            }
        }

        return result;
    }


    public static List<Integer> knuthMorrisPratt(String text, String pattern) {
        List<Integer> result = new ArrayList<>();

        if (pattern.isEmpty()) {
            return result;
        }
        int m = pattern.length();
        int n = text.length();

        int[] lps = new int[m];
        int j = 0;
        computeLPSArray(pattern, m, lps);

        int i = 0;
        while (i < n) {
            if (pattern.charAt(j) == text.charAt(i)) {
                j++;
                i++;
            }

            if (j == m) {
                result.add(i - j);
                j = lps[j - 1];
            } else if (i < n && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return result;
    }

    private static void computeLPSArray(String pattern, int m, int[] lps) {
        int length = 0;
        int i = 1;

        lps[0] = 0;

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }


    // Boyer-Moore Algorithm
    public static List<Integer> boyerMoore(String text, String pattern) {
        List<Integer> result = new ArrayList<>();
        int n = text.length();
        int m = pattern.length();
        int[] badChar = preprocessBadCharacter(pattern);

        int shift = 0;
        while (shift <= n - m) {
            int j = m - 1;
            while (j >= 0 && pattern.charAt(j) == text.charAt(shift + j)) j--;

            if (j < 0) {
                result.add(shift);
                shift += (shift + m < n) ? m - badChar[text.charAt(shift + m)] : 1;
            } else {
                shift += Math.max(1, j - badChar[text.charAt(shift + j)]);
            }
        }
        return result;
    }

    private static int[] preprocessBadCharacter(String pattern) {
        int[] badChar = new int[256];
        for (int i = 0; i < 256; i++) badChar[i] = -1;
        for (int i = 0; i < pattern.length(); i++) badChar[pattern.charAt(i)] = i;
        return badChar;
    }
}