import java.util.*;

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        // Case 1: rob from 0..n-2 (exclude last)
        int a = robLinear(nums, 0, n - 2);
        // Case 2: rob from 1..n-1 (exclude first)
        int b = robLinear(nums, 1, n - 1);
        return Math.max(a, b);
    }

    // Robber I on a linear slice [lo..hi] inclusive
    private int robLinear(int[] nums, int lo, int hi) {
        int prev2 = 0; // dp[i-2]
        int prev1 = 0; // dp[i-1]
        for (int i = lo; i <= hi; i++) {
            int pick = prev2 + nums[i];
            int skip = prev1;
            int cur = Math.max(pick, skip);
            prev2 = prev1;
            prev1 = cur;
        }
        return prev1;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] tests = {
            {2,3,2},           // -> 3
            {1,2,3,1},         // -> 4
            {1,2,3},           // -> 3
            {1},               // -> 1
            {0,0,0},           // -> 0
            {200,3,140,20,10}, // -> 340 (take 200 + 140)
            {2,7,9,3,1},       // -> 11 (circular: max(rob 0..3, rob 1..4) = 11)
            {5,1,1,5}          // -> 6 (take 1 + 5 in best circular split)
        };
    }
}