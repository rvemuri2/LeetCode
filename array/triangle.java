class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        // dp will hold the minimum path sum starting from the bottom row
        int[] dp = new int[n];

        // Initialize dp with the last row of the triangle
        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }

        // Start from the second-last row and move upward
        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                // For each element, choose the minimum path sum from the next row's adjacent elements
                int down = dp[col];
                int downRight = dp[col + 1];
                dp[col] = triangle.get(row).get(col) + Math.min(down, downRight);
            }
        }
        return dp[0];
    }
}