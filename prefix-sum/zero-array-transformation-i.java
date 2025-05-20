public class Solution {

    /**
     * Determines if it is possible to transform the given nums array into a zero array
     * using the provided range queries. Each query allows decrementing any subset of
     * values within the specified range by 1.
     *
     * @param nums    The initial array of non-negative integers.
     * @param queries The list of queries, each representing a [li, ri] range.
     * @return True if nums can be transformed into a zero array, false otherwise.
     */
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1]; // difference array to efficiently mark ranges

        // Apply the range increment logic using the difference array
        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];

            diff[l] += 1;
            if (r + 1 < n) {
                diff[r + 1] -= 1;
            }
        }

        // Calculate how many times each index is covered using prefix sum
        int[] coverage = new int[n];
        int curr = 0;
        for (int i = 0; i < n; i++) {
            curr += diff[i];
            coverage[i] = curr;
        }

        // Check if each value in nums can be reduced to zero using the coverage
        for (int i = 0; i < n; i++) {
            if (nums[i] > coverage[i]) {
                return false;
            }
        }

        return true;
    }

    // Optional: Test the function manually
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {1, 0, 1};
        int[][] queries1 = {{0, 2}};
        System.out.println(sol.isZeroArray(nums1, queries1)); // true
        int[] nums2 = {4, 3, 2, 1};
    }
}
