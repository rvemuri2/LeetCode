import java.util.*;

public class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        int[][] dp = new int[n][26];

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) queue.offer(i);
            dp[i][colors.charAt(i) - 'a'] = 1;
        }
        int visited = 0;
        int maxColorValue = 0;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            visited++;
            for (int v : graph.get(u)) {
                for (int c = 0; c < 26; c++) {
                    int val = dp[u][c] + (colors.charAt(v) - 'a' == c ? 1 : 0);
                    dp[v][c] = Math.max(dp[v][c], val);
                }
                indegree[v]--;
                if (indegree[v] == 0) queue.offer(v);
            }
            maxColorValue = Math.max(maxColorValue, Arrays.stream(dp[u]).max().getAsInt());
        }
        return visited == n ? maxColorValue : -1;
    }
}