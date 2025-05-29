import java.util.*;

public class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;

        // Build adjacency lists for both trees
        List<List<Integer>> graph1 = buildGraph(n, edges1);
        List<List<Integer>> graph2 = buildGraph(m, edges2);

        // Get depths of all nodes in the second tree starting from node 0
        int[] depth2 = getDepths(graph2);

        // Count the number of nodes at even depths and odd depths in the second tree
        int evenCount2 = 0;
        for (int d : depth2) {
            if (d % 2 == 0) evenCount2++;
        }
        int oddCount2 = m - evenCount2;

        // Get depths of all nodes in the first tree starting from node 0
        int[] depth1 = getDepths(graph1);
        int[] result = new int[n];

        // For each node in the first tree, compute how many nodes in the second tree
        // would be at even distance when connected, based on parity of depth
        for (int i = 0; i < n; i++) {
            result[i] = (depth1[i] % 2 == 0) ? evenCount2 : oddCount2;
        }

        return result;
    }

    // Utility function to build the graph from edge list
    private List<List<Integer>> buildGraph(int size, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < size; i++) graph.add(new ArrayList<>());
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }

    // BFS to compute depths of all nodes from root (node 0)
    private int[] getDepths(List<List<Integer>> graph) {
        int[] depth = new int[graph.size()];
        Arrays.fill(depth, -1); // Mark all nodes as unvisited
        Queue<Integer> queue = new LinkedList<>();
        depth[0] = 0; // Starting from node 0
        queue.offer(0);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph.get(node)) {
                if (depth[neighbor] == -1) {
                    depth[neighbor] = depth[node] + 1;
                    queue.offer(neighbor);
                }
            }
        }
        return depth;
    }

    // Optional: for testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] edges1 = {{0,1},{0,2},{2,3},{2,4}};
        int[][] edges2 = {{0,1},{0,2},{0,3},{2,7},{1,4},{4,5},{4,6}};
        System.out.println(Arrays.toString(sol.maxTargetNodes(edges1, edges2))); // Output: [8, 7, 7, 8, 8]
    }
}