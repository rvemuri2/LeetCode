class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        // dp will hold the minimum path sum starting from the bottom row
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }
        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                int down = dp[col];
                int downRight = dp[col + 1];
                dp[col] = triangle.get(row).get(col) + Math.min(down, downRight);
            }
        }
        return dp[0];
    }
}