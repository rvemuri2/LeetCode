import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {0, 2, 1, 5, 3, 4};
        int[] nums2 = {5, 0, 1, 2, 3, 4};

        System.out.println(Arrays.toString(sol.buildArray(nums1))); // Output: [0, 1, 2, 4, 5, 3]
        System.out.println(Arrays.toString(sol.buildArray(nums2))); // Output: [4, 5, 0, 1, 2, 3]
    }

    public int[] buildArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            ans[i] = nums[nums[i]];
        }

        return ans;
    }
}