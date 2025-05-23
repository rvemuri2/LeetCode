import java.util.*;

public class Solution {
    public int maximumValueSum(int[] nums, int k, int[][] edges) {
        long baseSum = 0;
        int flipCount = 0;
        long minAdjustment = Long.MAX_VALUE;

        for (int num : nums) {
            int flipped = num ^ k;
            baseSum += Math.max(num, flipped);

            int gain = flipped - num;
            if (gain > 0) {
                flipCount++;
            }

            // Track minimal penalty if we need to change flip decision
            minAdjustment = Math.min(minAdjustment, Math.abs(gain));
        }

        // Only even number of flips allowed
        if (flipCount % 2 == 0) {
            return (int)(baseSum % 1_000_000_007);
        } else {
            // Subtract the minimum impact flip to make count even
            return (int)((baseSum - minAdjustment + 1_000_000_007) % 1_000_000_007);
        }
    }

    // Optional: for testing
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test case: all same values, flipping hurts
        System.out.println(sol.maximumValueSum(
                new int[]{7, 7, 7, 7, 7, 7},
                1_000_000_000,
                new int[][]{{0,1},{0,2},{0,3},{0,4},{0,5}}
        )); // Expected: 6000000042 % MOD = 6000000042 % 1_000_000_007
    }
}