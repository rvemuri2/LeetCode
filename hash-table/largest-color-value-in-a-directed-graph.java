import java.util.*;

public class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[n];

        // Build graph
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }

        // Queue for Kahn's algorithm
        Queue<Integer> queue = new LinkedList<>();
        int[][] dp = new int[n][26];

        // Initialize: each node starts with its own color count as 1
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) queue.offer(i);
            dp[i][colors.charAt(i) - 'a'] = 1;
        }

        int visited = 0;
        int maxColorValue = 0;

        // BFS Topological Sort
        while (!queue.isEmpty()) {
            int u = queue.poll();
            visited++;
            for (int v : graph.get(u)) {
                // Update color frequency for node v based on node u
                for (int c = 0; c < 26; c++) {
                    int val = dp[u][c] + (colors.charAt(v) - 'a' == c ? 1 : 0);
                    dp[v][c] = Math.max(dp[v][c], val);
                }
                // Decrease indegree and add to queue if ready
                indegree[v]--;
                if (indegree[v] == 0) queue.offer(v);
            }

            // Update global max
            maxColorValue = Math.max(maxColorValue, Arrays.stream(dp[u]).max().getAsInt());
        }

        // If not all nodes were visited, there's a cycle
        return visited == n ? maxColorValue : -1;
    }
    // Test example
    public static void main(String[] args) {}
}