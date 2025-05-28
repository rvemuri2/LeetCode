import java.util.*;

public class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length + 1; // Nodes in first tree
        int m = edges2.length + 1; // Nodes in second tree

        List<List<Integer>> graph1 = buildGraph(n, edges1);
        List<List<Integer>> graph2 = buildGraph(m, edges2);

        int[][] reach1 = new int[n][k + 1];
        int[][] reach2 = new int[m][k + 1];

        for (int i = 0; i < n; i++) {
            reach1[i] = bfsReach(graph1, i, k);
        }
        for (int i = 0; i < m; i++) {
            reach2[i] = bfsReach(graph2, i, k);
        }

        int[] maxReach2 = new int[k + 1];
        for (int d = 0; d <= k; d++) {
            for (int i = 0; i < m; i++) {
                maxReach2[d] = Math.max(maxReach2[d], reach2[i][d]);
            }
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int d1 = 0; d1 <= k; d1++) {
                int d2 = k - d1;
                if (d2 <= k) {
                    int count = reach1[i][d1] + maxReach2[d2];
                    max = Math.max(max, count);
                }
            }
            result[i] = max;
        }

        return result;
    }

    private List<List<Integer>> buildGraph(int size, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }

    private int[] bfsReach(List<List<Integer>> graph, int start, int k) {
        int[] dist = new int[graph.size()];
        Arrays.fill(dist, -1);
        Queue<Integer> queue = new LinkedList<>();
        int[] reach = new int[k + 1];

        dist[start] = 0;
        reach[0] = 1;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            int d = dist[node];
            for (int neighbor : graph.get(node)) {
                if (dist[neighbor] == -1) {
                    dist[neighbor] = d + 1;
                    if (dist[neighbor] <= k) {
                        reach[dist[neighbor]]++;
                        queue.offer(neighbor);
                    }
                }
            }
        }

        for (int i = 1; i <= k; i++) {
            reach[i] += reach[i - 1];
        }

        return reach;
    }

    // Optional: for testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] edges1 = {{0,1},{0,2},{2,3},{2,4}};
        int[][] edges2 = {{0,1},{0,2},{0,3},{2,7},{1,4},{4,5},{4,6}};
        int k = 2;
        System.out.println(Arrays.toString(sol.maxTargetNodes(edges1, edges2, k))); // Output: [9, 7, 9, 8, 8]
    }
}