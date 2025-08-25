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
        Arrays.fill(dp, amount + 1); // sentinel larger than any possible answer
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

    // Quick tests
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.coinChange(new int[]{1, 2, 5}, 11)); // 3 (5+5+1)
        System.out.println(sol.coinChange(new int[]{2}, 3));        // -1
        System.out.println(sol.coinChange(new int[]{1}, 0));        // 0
        System.out.println(sol.coinChange(new int[]{2, 5, 10, 1}, 27)); // 4 (10+10+5+2)
    }
}