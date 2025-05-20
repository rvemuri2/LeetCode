public class Solution {
    public boolean canTransformToZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1]; // difference array for range update

        // Apply each query as a +1 in diff[li] and -1 in diff[ri+1]
        for (int[] query : queries) {
            int l = query[0], r = query[1];
            diff[l] += 1;
            if (r + 1 < n) {
                diff[r + 1] -= 1;
            }
        }

        // Compute prefix sum to get the number of times each index is covered
        int[] coverage = new int[n];
        int current = 0;
        for (int i = 0; i < n; i++) {
            current += diff[i];
            coverage[i] = current;
        }

        // Validate: nums[i] must be <= number of times it was covered
        for (int i = 0; i < n; i++) {
            if (nums[i] > coverage[i]) {
                return false;
            }
        }

        return true;
    }

    // Test the solution
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {1, 0, 1};
        int[][] queries1 = {{0, 2}};
        System.out.println(sol.canTransformToZeroArray(nums1, queries1)); // true

        int[] nums2 = {4, 3, 2, 1};
        int[][] queries2 = {{1, 3}, {0, 2}};
        System.out.println(sol.canTransformToZeroArray(nums2, queries2)); // false
    }
}
