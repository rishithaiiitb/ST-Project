package com.st.testing;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.*;

public class StringMatchingAlgorithmsTest {

    @Test
    public void testPositiveNaiveStringMatching() {
        assertEquals(Arrays.asList(0, 2), StringMatchingAlgorithms.naiveStringMatching("ABABABC", "ABAB"));
        assertEquals(Arrays.asList(1), StringMatchingAlgorithms.naiveStringMatching("ABCDE", "BC"));
    }

    @Test
    public void testNegativeNaiveStringMatching() {
        assertNotEquals(Arrays.asList(1), StringMatchingAlgorithms.naiveStringMatching("ABCDEFG", "HI"));
        assertNotEquals(Collections.singletonList(0), StringMatchingAlgorithms.naiveStringMatching("ABCDEFG", ""));
    }

    @Test
    public void testPositiveRabinKarp() {
        assertEquals(Arrays.asList(0, 1, 2), StringMatchingAlgorithms.rabinKarp("AAAAA", "AAA", 101));
        assertEquals(Arrays.asList(1), StringMatchingAlgorithms.rabinKarp("ABCDE", "BC", 101));
    }

    @Test
    public void testNegativeRabinKarp() {
        assertNotEquals(Arrays.asList(0), StringMatchingAlgorithms.rabinKarp("ABCDEFG", "XYZ", 101));
        assertNotEquals(Collections.singletonList(1), StringMatchingAlgorithms.rabinKarp("ABCDEFG", "", 101));
    }


    @Test
    public void testPositiveKnuthMorrisPratt() {
        assertEquals(Arrays.asList(0, 2), StringMatchingAlgorithms.knuthMorrisPratt("ABABABC", "ABAB"));
        assertEquals(Arrays.asList(1), StringMatchingAlgorithms.knuthMorrisPratt("ABCDE", "BC"));
    }

    @Test
    public void testNegativeKnuthMorrisPratt() {
        assertNotEquals(Arrays.asList(1), StringMatchingAlgorithms.knuthMorrisPratt("ABCDEFG", "HI"));
        assertNotEquals(Collections.singletonList(0), StringMatchingAlgorithms.knuthMorrisPratt("ABCDEFG", ""));
    }

    @Test
    public void testPositiveBoyerMoore() {
        assertEquals(Arrays.asList(0, 2), StringMatchingAlgorithms.boyerMoore("ABABABC", "ABAB"));
        assertEquals(Arrays.asList(1), StringMatchingAlgorithms.boyerMoore("ABCDE", "BC"));
    }

    @Test
    public void testNegativeBoyerMoore() {
        assertNotEquals(Arrays.asList(0), StringMatchingAlgorithms.boyerMoore("ABCDEFG", "XYZ"));
        assertNotEquals(Collections.singletonList(1), StringMatchingAlgorithms.boyerMoore("ABCDEFG", ""));
    }

    @Test
    public void testPositiveEdgeCases() {
        assertEquals(List.of(0), StringMatchingAlgorithms.naiveStringMatching("", ""));
        assertEquals(List.of(0), StringMatchingAlgorithms.rabinKarp("", "", 101));
        assertEquals(List.of(), StringMatchingAlgorithms.knuthMorrisPratt("", ""));
        assertEquals(List.of(0), StringMatchingAlgorithms.boyerMoore("", ""));
    }

    @Test
    public void testNegativeEdgeCases() {
        assertNotEquals(Collections.singletonList(0), StringMatchingAlgorithms.naiveStringMatching("A", "AB"));
        assertNotEquals(Collections.singletonList(0), StringMatchingAlgorithms.rabinKarp("A", "AB", 101));
        assertNotEquals(Collections.singletonList(0), StringMatchingAlgorithms.knuthMorrisPratt("A", "AB"));
        assertNotEquals(Collections.singletonList(0), StringMatchingAlgorithms.boyerMoore("A", "AB"));
    }

    @Test
    public void testNoMatches() {
        assertEquals(Collections.emptyList(), StringMatchingAlgorithms.naiveStringMatching("ABCDEFG", "XYZ"));
        assertEquals(Collections.emptyList(), StringMatchingAlgorithms.rabinKarp("ABCDEFG", "XYZ", 101));
        assertEquals(Collections.emptyList(), StringMatchingAlgorithms.knuthMorrisPratt("ABCDEFG", "XYZ"));
        assertEquals(Collections.emptyList(), StringMatchingAlgorithms.boyerMoore("ABCDEFG", "XYZ"));
    }

    @Test
    public void testSingleCharacterTextAndPattern() {
        assertEquals(List.of(0), StringMatchingAlgorithms.naiveStringMatching("A", "A"));
        assertEquals(List.of(0), StringMatchingAlgorithms.rabinKarp("A", "A", 101));
        assertEquals(List.of(0), StringMatchingAlgorithms.knuthMorrisPratt("A", "A"));
        assertEquals(List.of(0), StringMatchingAlgorithms.boyerMoore("A", "A"));
    }

    @Test
    public void testRepeatingPattern() {
        assertEquals(Arrays.asList(0, 1, 2), StringMatchingAlgorithms.naiveStringMatching("AAAAA", "AAA"));
        assertEquals(Arrays.asList(0, 1, 2), StringMatchingAlgorithms.rabinKarp("AAAAA", "AAA", 101));
        assertEquals(Arrays.asList(0, 1, 2), StringMatchingAlgorithms.knuthMorrisPratt("AAAAA", "AAA"));
        assertEquals(Arrays.asList(0, 1, 2), StringMatchingAlgorithms.boyerMoore("AAAAA", "AAA"));
    }
}
