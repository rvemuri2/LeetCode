import java.util.*;

class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        if (n % 3 != 0) return new int[0][0];

        Arrays.sort(nums); // Sort to ensure we can group closest numbers together
        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < n; i += 3) {
            int a = nums[i];
            int b = nums[i + 1];
            int c = nums[i + 2];

            // Check if the difference between max and min in this group is within k
            if (c - a > k) {
                return new int[0][0]; // Cannot group, return empty array
            }

            result.add(new int[]{a, b, c});
        }

        // Convert List<int[]> to int[][]
        return result.toArray(new int[result.size()][]);
    }

    // Test cases
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {1,3,4,8,7,9,3,5,1};
        int k1 = 2;
        System.out.println(Arrays.deepToString(sol.divideArray(nums1, k1))); // Expected: Valid triplets

        int[] nums2 = {2,4,2,2,5,2};
        int k2 = 2;
        System.out.println(Arrays.deepToString(sol.divideArray(nums2, k2))); // Expected: []

        int[] nums3 = {4,2,9,8,2,12,7,12,10,5,8,5,5,7,9,2,5,11};
        int k3 = 14;
        System.out.println(Arrays.deepToString(sol.divideArray(nums3, k3))); // Expected: Valid triplets
    }
}