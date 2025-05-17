public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // DP table to store minimum path sums
        int[][] dp = new int[m][n];

        // Initialize the start point
        dp[0][0] = grid[0][0];

        // Fill the first row (only right moves allowed)
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        // Fill the first column (only down moves allowed)
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        // Fill the rest of the DP table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        // Return the value at the bottom-right cell
        return dp[m - 1][n - 1];
    }

    // Test the solution
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] grid1 = {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
        };
        System.out.println("Minimum Path Sum: " + sol.minPathSum(grid1)); // Output: 7

        int[][] grid2 = {
            {1, 2, 3},
            {4, 5, 6}
        };
        System.out.println("Minimum Path Sum: " + sol.minPathSum(grid2)); // Output: 12
    }
}
