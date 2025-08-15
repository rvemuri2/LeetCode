import java.util.*;

class Solution {
    /**
     * Maximal Square (DP)
     *
     * Let dp[i+1][j+1] be the side length of the largest all-1s square
     * whose bottom-right corner is at matrix[i][j].
     * Transition (only if matrix[i][j] == '1'):
     *   dp[i+1][j+1] = 1 + min(dp[i][j+1], dp[i+1][j], dp[i][j])
     * Track the maximum side length; the answer is side^2 (area).
     *
     * Time:  O(m * n)
     */
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        int maxSide = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[i + 1][j + 1] = 1 + Math.min(dp[i][j], Math.min(dp[i][j + 1], dp[i + 1][j]));
                    maxSide = Math.max(maxSide, dp[i + 1][j + 1]);
                }
            }
        }
        return maxSide * maxSide;
    }
}