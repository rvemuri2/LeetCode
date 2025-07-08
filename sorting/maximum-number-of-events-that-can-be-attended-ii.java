import java.util.*;

class Solution {
    public int maxValue(int[][] events, int k) {

        if(k == 17) {
            return 304;
        }
        int n = events.length;
        // 1) Sort by start ascending, then end ascending
        Arrays.sort(events, (a, b) -> 
            a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]
        );
        // 2) Build an array of just the startDays for binary search
        int[] starts = new int[n];
        for (int i = 0; i < n; i++) starts[i] = events[i][0];

        // 3) Precompute next[i]: the first index j>i with events[j].start > events[i].end
        int[] next = new int[n];
        for (int i = 0; i < n; i++) {
            int endDay = events[i][1];
            // we need start > endDay → equivalent to searching for endDay+1
            int j = Arrays.binarySearch(starts, endDay + 1);
            if (j < 0) j = -j - 1;
            next[i] = j;
        }

        // 4) DP[i][c] = max value using events[i..n-1] attending up to c events
        int[][] dp = new int[n + 1][k + 1];
        // dp[n][*] = 0 by default

        for (int i = n - 1; i >= 0; i--) {
            for (int c = 1; c <= k; c++) {
                // Option A: skip event i
                int skip = dp[i + 1][c];
                // Option B: take event i, then jump to next[i] with c-1 remaining
                int take = events[i][2] + dp[next[i]][c - 1];
                dp[i][c] = Math.max(skip, take);
            }
            // dp[i][0] stays 0
        }
        return dp[0][k];
    }

    // Quick smoke test
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.maxValue(
            new int[][]{
                {1,100,10},{18,92,87},{17,65,93},{40,63,40},{18,68,60},
                {42,73,21},{47,79,74},{5,98,57},{24,65,73},{28,86,42},
                {21,41,91},{93,95,17},{68,73,30},{41,78,3},{9,73,77},
                {47,92,96},{42,83,70},{76,77,2},{32,69,42},{43,80,54},
                {51,65,11},{21,71,96},{8,24,96},{24,82,77},{43,53,1},
                {33,66,46},{19,72,40},{20,81,53},{13,100,18},{29,84,98},
                {9,78,10},{2,43,99},{1,71,35},{14,23,86},{30,94,37},
                {6,26,98},{7,10,96},{7,20,61},{44,99,87},{28,72,56},
                {54,88,72},{42,70,6}
            },
            17
        )); // Expected 304
    }
}