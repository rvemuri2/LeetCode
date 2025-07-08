import java.util.*;

class Solution {
    /**
     * We have up to k * n ≤ 10^6, so an O(n · k · log n) DP with
     * next‐event binary search and a dp table of size (n+1)×(k+1) fits.
     */
    public int maxValue(int[][] events, int k) {
        int n = events.length;
        // 1) Sort events by start time
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        // 2) Extract starts for binary search
        int[] starts = new int[n];
        for (int i = 0; i < n; i++) starts[i] = events[i][0];
        // 3) Compute next[i]: first index whose start > events[i][1]
        int[] next = new int[n];
        for (int i = 0; i < n; i++) {
            int endi = events[i][1];
            int idx = Arrays.binarySearch(starts, endi + 1);
            if (idx < 0) idx = -idx - 1;
            next[i] = idx;
        }
        // 4) DP[i][j] = max value using events[i..n-1] attending up to j events
        int[][] dp = new int[n + 1][k + 1];
        // dp[n][*] = 0 by default

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= k; j++) {
                // option1: skip event i
                int opt1 = dp[i + 1][j];
                // option2: take event i
                int opt2 = events[i][2] + dp[next[i]][j - 1];
                dp[i][j] = Math.max(opt1, opt2);
            }
            // dp[i][0] = 0 already
        }
        return dp[0][k];
    }

    // ---------- Simple tests -------------
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maxValue(
            new int[][]{{1,2,4},{3,4,3},{2,3,1}}, 2
        )); // 7

        System.out.println(sol.maxValue(
            new int[][]{{1,2,4},{3,4,3},{2,3,10}}, 2
        )); // 10

        System.out.println(sol.maxValue(
            new int[][]{{1,1,1},{2,2,2},{3,3,3},{4,4,4}}, 3
        )); // 9
    }
}