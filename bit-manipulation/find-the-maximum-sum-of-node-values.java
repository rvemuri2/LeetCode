import java.util.*;

public class Solution {
    public int maximumValueSum(int[] nums, int k, int[][] edges) {
        int n = nums.length;
        List<Integer>[] tree = new ArrayList[n];
        for (int i = 0; i < n; i++) tree[i] = new ArrayList<>();

        // Build adjacency list
        for (int[] e : edges) {
            tree[e[0]].add(e[1]);
            tree[e[1]].add(e[0]);
        }

        long[] result = dfs(0, -1, nums, k, tree);
        return (int) Math.max(result[0], result[1]);
    }

    // Returns: [dp0, dp1] → max sum when this node is not flipped / is flipped
    private long[] dfs(int node, int parent, int[] nums, int k, List<Integer>[] tree) {
        long dp0 = nums[node];        // this node is not flipped
        long dp1 = nums[node] ^ k;    // this node is flipped

        for (int child : tree[node]) {
            if (child == parent) continue;

            long[] childDP = dfs(child, node, nums, k, tree);

            long newDp0 = Math.max(dp0 + childDP[0], dp1 + childDP[1]);
            long newDp1 = Math.max(dp0 + childDP[1], dp1 + childDP[0]);

            dp0 = newDp0;
            dp1 = newDp1;
        }

        return new long[]{dp0, dp1};
    }

    // Test the solution
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.maximumValueSum(
                new int[]{1, 2, 1},
                3,
                new int[][]{{0, 1}, {0, 2}})); // Output: 6

        System.out.println(sol.maximumValueSum(
                new int[]{2, 3},
                7,
                new int[][]{{0, 1}})); // Output: 9

        System.out.println(sol.maximumValueSum(
                new int[]{7, 7, 7, 7, 7, 7},
                3,
                new int[][]{{0, 1}, {0, 2}, {0, 3}, {0, 4}, {0, 5}})); // Output: 42
    }
}