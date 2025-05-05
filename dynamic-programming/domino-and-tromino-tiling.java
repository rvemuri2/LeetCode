public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test cases
        System.out.println(sol.numTilings(3)); // Output: 5
        System.out.println(sol.numTilings(1)); // Output: 1
    }

    public int numTilings(int n) {
        final int MOD = 1_000_000_007; // Use modulo to avoid integer overflow

        // Base cases
        if (n == 0) return 1; // An empty board has 1 way (doing nothing)
        if (n == 1) return 1; // Only one vertical domino fits
        if (n == 2) return 2; // Either two vertical dominoes or two horizontal ones

        // dp[i] = number of ways to tile a 2 x i board
        long[] dp = new long[n + 1];

        // Initialize base cases
        dp[0] = 1; // Empty board
        dp[1] = 1;
        dp[2] = 2; 

        for (int i = 3; i <= n; i++) {
            dp[i] = (2 * dp[i - 1] + dp[i - 3]) % MOD;
        }

        return (int) dp[n];
    }
}
