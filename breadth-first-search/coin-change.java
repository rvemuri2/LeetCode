import java.util.*;

class Solution {
    /**
     * Classic unbounded coin change (fewest coins).
     * Bottom-up DP where dp[a] = min coins to make amount 'a'.
     *
     * Time  : O(amount * coins.length)
     * Space : O(amount)
     */
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        // dp[a] = fewest coins to make 'a'; initialize to "infinity"
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int a = 1; a <= amount; a++) {
            for (int c : coins) {
                if (c <= a) {
                    dp[a] = Math.min(dp[a], dp[a - c] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}