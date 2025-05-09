public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.minDistance("horse", "ros"));        // Output: 3
        System.out.println(sol.minDistance("intention", "execution")); // Output: 5
    }

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // dp[i][j] = min steps to convert first i chars of word1 to first j chars of word2
        int[][] dp = new int[m + 1][n + 1];

        // Initialize base cases
        for (int i = 0; i <= m; i++) dp[i][0] = i; // Deleting all characters
        for (int j = 0; j <= n; j++) dp[0][j] = j; // Inserting all characters

        // Fill the dp table
        for (int i = 1; i <= m; i++) {
            char c1 = word1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = word2.charAt(j - 1);

                if (c1 == c2) {
                    // Characters match, no operation needed
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int insert = dp[i][j - 1];
                    int delete = dp[i - 1][j];
                    int replace = dp[i - 1][j - 1];
                    dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
                }
            }
        }

        return dp[m][n];
    }
}