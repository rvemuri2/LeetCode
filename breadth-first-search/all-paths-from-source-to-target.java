import java.util.*;

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(0, graph, path, ans, graph.length - 1);
        return ans;
    }

    private void dfs(int node, int[][] graph, List<Integer> path, List<List<Integer>> ans, int target) {
        if (node == target) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int nxt : graph[node]) {
            path.add(nxt);
            dfs(nxt, graph, path, ans, target);
            path.remove(path.size() - 1); // backtrack
        }
    }

    // --- simple test runner ---
    public static void main(String[] args) {
        Solution s = new Solution();

    }
}