import java.util.*;

class Solution {
    // Minimum operations to make XOR of array equal to k
    public int minOperations(int[] nums, int k) {
        int x = 0;
        for (int v : nums) x ^= v;          // XOR of all elements
        return Integer.bitCount(x ^ k);     // number of differing bits
    }
}

public class Main {
    private static void runTest(int[] nums, int k, int expected) {
        Solution sol = new Solution();
        int got = sol.minOperations(nums, k);
        System.out.printf("nums=%s, k=%d -> got=%d, expected=%d %s%n",
                Arrays.toString(nums), k, got, expected,
                (got == expected ? "✓" : "✗"));
    }

    public static void main(String[] args) {
        // Example 1
        runTest(new int[]{2, 1, 3, 4}, 1, 2);

        // Example 2
        runTest(new int[]{2, 0, 2, 0}, 0, 0);

        // Already equals k; no ops
        runTest(new int[]{5}, 5, 0);

        // Need to flip multiple bits
        // nums XOR = 7 (111), target k = 0 (000) -> 3 differing bits
        runTest(new int[]{1, 2, 4}, 0, 3);

        // Larger numbers; check differing bits only matter
        // x = 10 ^ 6 ^ 3 = (1010)^(0110)^(0011) = 1101 (13)
        // k = 9 (1001), x^k = 1101 ^ 1001 = 0100 -> 1 bit
        runTest(new int[]{10, 6, 3}, 9, 1);

        // Many zeros, k nonzero -> popcount(k) flips
        runTest(new int[]{0,0,0,0}, 13, Integer.bitCount(13)); // 13 -> 1101 -> 3

        // Random test
        runTest(new int[]{7, 7, 7}, 7, 0);
    }
}