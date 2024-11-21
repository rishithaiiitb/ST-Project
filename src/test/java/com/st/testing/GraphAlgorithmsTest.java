package com.st.testing;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class GraphAlgorithmsTest {

    @Test
    public void testBfsPositive() {
        Map<Integer, List<Integer>> graph1 = new HashMap<>();
        graph1.put(1, Arrays.asList(2, 3));
        graph1.put(2, Arrays.asList(1, 4));
        graph1.put(3, Arrays.asList(1));
        graph1.put(4, Arrays.asList(2));

        List<Integer> result1 = GraphAlgorithms.bfs(1, graph1);
        assertEquals(Arrays.asList(1, 2, 3, 4), result1);

        Map<Integer, List<Integer>> graph2 = new HashMap<>();
        graph2.put(1, Arrays.asList(2, 3));
        graph2.put(2, Arrays.asList(1));
        graph2.put(3, Arrays.asList(1));
        graph2.put(5, Arrays.asList(6));
        graph2.put(6, Arrays.asList(5));

        List<Integer> result2 = GraphAlgorithms.bfs(1, graph2);
        assertEquals(Arrays.asList(1, 2, 3), result2);

        Map<Integer, List<Integer>> graph3 = new HashMap<>();
        graph3.put(1, Arrays.asList(2));
        graph3.put(2, Arrays.asList(1));
        graph3.put(3, new ArrayList<>());

        List<Integer> result3 = GraphAlgorithms.bfs(1, graph3);
        assertEquals(Arrays.asList(1, 2), result3);

        Map<Integer, List<Integer>> graph4 = new HashMap<>();
        graph4.put(1, Arrays.asList(1, 2));
        graph4.put(2, Arrays.asList(3));
        graph4.put(3, new ArrayList<>());

        List<Integer> result = GraphAlgorithms.bfs(1, graph4);
        assertEquals(Arrays.asList(1, 2, 3), result);


    }

    @Test
    public void testBfsNegative() {
        List<Integer> result3 = GraphAlgorithms.bfs(7, new HashMap<>());
        assertNotEquals(Arrays.asList(7), result3);
        assertNotEquals(Collections.singletonList(7), result3);
    }

    @Test
    public void testDfsPositive() {
        Map<Integer, List<Integer>> graph1 = new HashMap<>();
        graph1.put(1, Arrays.asList(2, 3));
        graph1.put(2, Arrays.asList(1, 4));
        graph1.put(3, Arrays.asList(1));
        graph1.put(4, Arrays.asList(2));

        List<Integer> result1 = GraphAlgorithms.dfs(1, graph1);
        assertEquals(Arrays.asList(1, 2, 4, 3), result1);

        Map<Integer, List<Integer>> graph2 = new HashMap<>();
        graph2.put(1, Arrays.asList(3, 2));
        graph2.put(2, Arrays.asList(4));
        graph2.put(3, new ArrayList<>());
        graph2.put(4, new ArrayList<>());

        List<Integer> result2 = GraphAlgorithms.dfs(1, graph2);
        assertEquals(Arrays.asList(1, 2, 4, 3), result2);

        Map<Integer, List<Integer>> graph3 = new HashMap<>();
        graph3.put(1, Arrays.asList(2));
        graph3.put(2, Arrays.asList(3));
        graph3.put(3, Arrays.asList(1));

        List<Integer> result3 = GraphAlgorithms.dfs(1, graph3);
        assertEquals(Arrays.asList(1, 2, 3), result3);
    }

    @Test
    public void testDfsNegative() {
        Map<Integer, List<Integer>> graph2 = new HashMap<>();
        graph2.put(1, Arrays.asList(2));
        graph2.put(2, Arrays.asList(1));
        graph2.put(3, new ArrayList<>());
        List<Integer> result2 = GraphAlgorithms.dfs(1, graph2);
        assertNotEquals(Arrays.asList(1, 2, 3), result2);
    }

    @Test
    public void testDijkstraPostive() {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(new int[]{1, 1}));
        graph.put(1, new ArrayList<>());
        graph.put(2, new ArrayList<>());

        Map<Integer, Integer> result = GraphAlgorithms.dijkstra(graph, 0);
        assertEquals(Map.of(0, 0, 1, 1), result);

        Map<Integer, List<int[]>> graph1 = new HashMap<>();
        Map<Integer, Integer> result1 = GraphAlgorithms.dijkstra(graph1, 0);
        assertTrue(result1.isEmpty());

    }

    @Test
    public void testDijkstraNegative() {
        Map<Integer, List<int[]>> graph2 = new HashMap<>();
        graph2.put(0, Arrays.asList(new int[]{1, -1}));
        graph2.put(1, Arrays.asList(new int[]{2, 2}));
        graph2.put(2, Arrays.asList(new int[]{0, 5}));

        try {
            GraphAlgorithms.dijkstra(graph2, 0);
            fail("Expected IllegalArgumentException due to negative weight");
        } catch (IllegalArgumentException e) {
        }

        Map<Integer, Integer> result3 = GraphAlgorithms.dijkstra(new HashMap<>(), 5);
        assertNotEquals(Map.of(5, 0), result3);
        assertNotEquals(Collections.singletonMap(5, 0), result3);
    }


    @Test
    public void testKruskalPositive() {
        int[][] edges1 = {{0, 1, 1}, {1, 2, 2}, {2, 0, 2}};
        int result1 = GraphAlgorithms.kruskal(3, edges1);
        assertEquals(3, result1);

        int[][] edges = {{0, 1, 1}, {2, 3, 2}};
        int result = GraphAlgorithms.kruskal(4, edges);
        assertEquals(-1, result);

        int[][] edges2 = {{0, 1, 10}};
        int result2 = GraphAlgorithms.kruskal(2, edges2);
        assertEquals(10, result2);


    }

    @Test
    public void testKruskalNegative() {
        int[][] edges2 = {{0, 1, 3}, {1, 2, 2}, {2, 3, 1}, {0, 3, 4}};
        int result2 =  GraphAlgorithms.kruskal(5, edges2);
        assertNotEquals(6, result2);
    }

    @Test
    public void testPrimPositive() {
        int[][] edges1 = {{0, 1, 10}, {0, 2, 6}, {1, 2, 5}, {2, 3, 2}, {3, 0, 1}};
        int result1 =  GraphAlgorithms.prim(4, edges1);
        assertEquals(8, result1);

        int[][] edges = new int[0][];
        int result = GraphAlgorithms.prim(3, edges);
        assertEquals(-1, result);

        int[][] edges2 = {{0, 1, 5}, {1, 2, 5}, {0, 2, 5}};
        int result2 = GraphAlgorithms.prim(3, edges2);
        assertEquals(10, result2);

    }

    @Test
    public void testPrimNegative() {
        int[][] edges2 = {{0, 1, 2}, {1, 2, 3}, {2, 3, 4}, {0, 3, 5}};
        int result2 =  GraphAlgorithms.prim(5, edges2);
        assertNotEquals(9, result2);
    }

    @Test
    public void testFloydWarshallPositive() {
        int[][] graph1 = {
                {0, 3, Integer.MAX_VALUE, Integer.MAX_VALUE},
                {3, 0, 1, 7},
                {Integer.MAX_VALUE, 1, 0, 2},
                {Integer.MAX_VALUE, 7, 2, 0}
        };
        int[][] result1 =  GraphAlgorithms.floydWarshall(graph1);
        int[][] expected1 = {
                {0, 3, 4, 6},
                {3, 0, 1, 3},
                {4, 1, 0, 2},
                {6, 3, 2, 0}
        };
        assertArrayEquals(expected1, result1);

        int[][] graph = {
                {0, Integer.MAX_VALUE, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, 0, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, 0}
        };
        int[][] result = GraphAlgorithms.floydWarshall(graph);
        assertArrayEquals(graph, result);

        int[][] graph2 = {
                {0, 1, Integer.MAX_VALUE},
                {1, 0, 1},
                {Integer.MAX_VALUE, 1, 0}
        };
        int[][] expected = {
                {0, 1, 2},
                {1, 0, 1},
                {2, 1, 0}
        };
        int[][] result2 = GraphAlgorithms.floydWarshall(graph2);
        assertArrayEquals(expected, result2);

    }

    @Test
    public void testFloydWarshallNegative() {
        int[][] graph3 = {
                {0, -1, Integer.MAX_VALUE},
                {-1, 0, -1},
                {Integer.MAX_VALUE, -1, 0}
        };
        try {
            GraphAlgorithms.floydWarshall(graph3);
            fail("Expected IllegalArgumentException due to negative cycle");
        } catch (IllegalArgumentException e) {
        }
    }
}