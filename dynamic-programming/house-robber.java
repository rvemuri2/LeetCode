class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        // Edge case: only 1 house
        if (n == 1) return nums[0];

        // Edge case: only 2 houses, pick the one with more money
        if (n == 2) return Math.max(nums[0], nums[1]);

        // DP array to store max money robbed up to each house
        int[] dp = new int[n];
        
        // Base cases
        dp[0] = nums[0];                        // Rob first house
        dp[1] = Math.max(nums[0], nums[1]);     // Rob richer of first two

        // Build the dp array
        for (int i = 2; i < n; i++) {
            // Either rob current + dp[i-2], or skip and take dp[i-1]
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        // Final result is max money up to last house
        return dp[n - 1];
    }

    // Example test
    public static void main(String[] args) {
        Solution sol = new Solution();
    }
}