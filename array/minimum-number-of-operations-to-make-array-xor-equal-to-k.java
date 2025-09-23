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
    }
}