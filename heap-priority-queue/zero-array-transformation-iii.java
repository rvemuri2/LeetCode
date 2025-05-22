import java.util.*;

public class Solution {
    public int maxQueriesToRemove(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;
        int[] coverage = new int[n + 1];  // use difference array

        // Step 1: Apply all queries to coverage using diff array
        for (int[] query : queries) {
            int l = query[0], r = query[1];
            coverage[l]++;
            if (r + 1 < n) coverage[r + 1]--;
        }

        // Step 2: Prefix sum to get total coverage per index
        for (int i = 1; i < n; i++) {
            coverage[i] += coverage[i - 1];
        }

        // Step 3: Check if it's even possible to reach zero array
        for (int i = 0; i < n; i++) {
            if (coverage[i] < nums[i]) return -1;
        }

        // Step 4: Greedily try to remove queries
        // We’ll maintain how many times each index is covered
        int[] count = Arrays.copyOfRange(coverage, 0, n);
        boolean[] used = new boolean[q];
        int removable = 0;

        for (int i = q - 1; i >= 0; i--) { // try removing in reverse order
            int l = queries[i][0], r = queries[i][1];
            boolean canRemove = true;
            for (int j = l; j <= r; j++) {
                if (count[j] <= nums[j]) {
                    canRemove = false;
                    break;
                }
            }

            if (canRemove) {
                for (int j = l; j <= r; j++) {
                    count[j]--;
                }
                removable++;
                used[i] = true;
            }
        }

        return removable;
    }

    // Test cases
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {2, 0, 2};
        int[][] queries1 = {{0, 2}, {0, 2}, {1, 1}};
        System.out.println(sol.maxQueriesToRemove(nums1, queries1)); // Output: 1

        int[] nums2 = {1, 1, 1, 1};
        int[][] queries2 = {{1, 3}, {0, 2}, {1, 3}, {1, 2}};
        System.out.println(sol.maxQueriesToRemove(nums2, queries2)); // Output: 2

        int[] nums3 = {1, 2, 3, 4};
        int[][] queries3 = {{0, 3}};
        System.out.println(sol.maxQueriesToRemove(nums3, queries3)); // Output: -1
    }
}
