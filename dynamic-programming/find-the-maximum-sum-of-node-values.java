import java.util.*;

public class Solution {
    public int maximumValueSum(int[] nums, int k, int[][] edges) {
        long total = 0;
        int gainCount = 0;
        int minGainChange = Integer.MAX_VALUE;

        for (int num : nums) {
            int flipped = num ^ k;
            total += Math.max(num, flipped);

            int gain = flipped - num;
            if (gain > 0) gainCount++;

            // Track the minimum cost to undo a flip if needed
            minGainChange = Math.min(minGainChange, Math.abs(gain));
        }

        // If gainCount is even, total is already maximal
        // If gainCount is odd, we must undo one flip
        if (gainCount % 2 == 0) {
            return (int)(total);
        } else {
            return (int)(total - minGainChange);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.maximumValueSum(
                new int[]{1, 2, 1},
                3,
                new int[][]{{0, 1}, {0, 2}})); // 6

        System.out.println(sol.maximumValueSum(
                new int[]{24, 78, 1, 97, 44},
                6,
                new int[][]{{0,2},{1,2},{4,2},{3,4}})); // 260
    }
}