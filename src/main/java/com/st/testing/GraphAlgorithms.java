package com.st.testing;

import java.util.*;

public class GraphAlgorithms {

    // Breadth-First Search (BFS)
    public static List<Integer> bfs(int start, Map<Integer, List<Integer>> graph) {
        if (!graph.containsKey(start)) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);

            for (int neighbor : graph.getOrDefault(node, Collections.emptyList())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        return result;
    }


    // Depth-First Search (DFS)
    public static List<Integer> dfs(int start, Map<Integer, List<Integer>> graph) {
        if (!graph.containsKey(start)) {
            return Collections.emptyList();
        }

        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        dfsHelper(start, graph, visited, result);
        return result;
    }

    private static void dfsHelper(int node, Map<Integer, List<Integer>> graph, Set<Integer> visited, List<Integer> result) {
        visited.add(node);
        result.add(node);

        List<Integer> neighbors = new ArrayList<>(graph.getOrDefault(node, Collections.emptyList()));
        Collections.sort(neighbors);

        for (int neighbor : neighbors) {
            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor, graph, visited, result);
            }
        }
    }


    // Dijkstra's Algorithm (Shortest Path)
    public static Map<Integer, Integer> dijkstra(Map<Integer, List<int[]>> graph, int start) {
        if (!graph.containsKey(start)) {
            return Collections.emptyMap();
        }

        for (Map.Entry<Integer, List<int[]>> entry : graph.entrySet()) {
            for (int[] edge : entry.getValue()) {
                if (edge[1] < 0) {
                    throw new IllegalArgumentException("Graph contains negative edge weights, which Dijkstra's algorithm does not handle.");
                }
            }
        }

        Map<Integer, Integer> distances = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        distances.put(start, 0);
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int currentNode = node[0];
            int currentDistance = node[1];

            if (currentDistance > distances.getOrDefault(currentNode, Integer.MAX_VALUE)) {
                continue;
            }

            for (int[] neighbor : graph.getOrDefault(currentNode, Collections.emptyList())) {
                int nextNode = neighbor[0];
                int weight = neighbor[1];
                int newDistance = currentDistance + weight;

                if (newDistance < distances.getOrDefault(nextNode, Integer.MAX_VALUE)) {
                    distances.put(nextNode, newDistance);
                    pq.offer(new int[]{nextNode, newDistance});
                }
            }
        }
        return distances;
    }

    // Kruskal's
    public static int kruskal(int numNodes, int[][] edges) {
        if (edges.length == 0) {
            return 0;
        }

        Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));

        int[] parent = new int[numNodes];
        int[] rank = new int[numNodes];
        for (int i = 0; i < numNodes; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        int mstWeight = 0;
        int edgesCount = 0;

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];

            if (find(u, parent) != find(v, parent)) {
                union(u, v, parent, rank);
                mstWeight += weight;
                edgesCount++;
            }
        }

        if (edgesCount != numNodes - 1) {
            return -1;
        }

        return mstWeight;
    }

    private static int find(int x, int[] parent) {
        if (parent[x] != x) {
            parent[x] = find(parent[x], parent);
        }
        return parent[x];
    }

    private static void union(int x, int y, int[] parent, int[] rank) {
        int rootX = find(x, parent);
        int rootY = find(y, parent);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }


    // Prim's
    public static int prim(int numNodes, int[][] edges) {
        if (edges.length == 0) {
            return -1;
        }

        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(new int[]{edge[1], edge[2]});
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(new int[]{edge[0], edge[2]});
        }

        Set<Integer> visited = new HashSet<>();

        primHelper(0, graph, visited);

        if (visited.size() != numNodes) {
            return -1;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        boolean[] inMST = new boolean[numNodes];
        int mstWeight = 0;
        pq.offer(new int[]{0, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int weight = current[1];

            if (inMST[node]) {
                continue;
            }

            inMST[node] = true;
            mstWeight += weight;

            for (int[] neighbor : graph.getOrDefault(node, Collections.emptyList())) {
                int nextNode = neighbor[0];
                int edgeWeight = neighbor[1];
                if (!inMST[nextNode]) {
                    pq.offer(new int[]{nextNode, edgeWeight});
                }
            }
        }

        return mstWeight;
    }


    private static void primHelper(int node, Map<Integer, List<int[]>> graph, Set<Integer> visited) {
        visited.add(node);
        for (int[] neighbor : graph.getOrDefault(node, Collections.emptyList())) {
            if (!visited.contains(neighbor[0])) {
                primHelper(neighbor[0], graph, visited);
            }
        }
    }


    // Floyd Warshall
    public static int[][] floydWarshall(int[][] graph) {
        int n = graph.length;
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else if (graph[i][j] != Integer.MAX_VALUE) {
                    dist[i][j] = graph[i][j];
                } else {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (dist[i][i] < 0) {
                throw new IllegalArgumentException("Graph contains a negative cycle");
            }
        }
        return dist;
    }
}