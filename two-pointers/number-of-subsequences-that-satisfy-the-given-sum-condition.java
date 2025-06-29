import java.util.Arrays;

class Solution {
    public int numSubseq(int[] nums, int target) {
        int MOD = 1_000_000_007;
        int n = nums.length;
        Arrays.sort(nums);

        // Precompute powers of 2 up to n
        int[] pow2 = new int[n];
        pow2[0] = 1;
        for (int i = 1; i < n; i++) {
            pow2[i] = (pow2[i - 1] * 2) % MOD;
        }

        int left = 0, right = n - 1;
        int res = 0;

        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                // Number of subsequences is 2^(right-left)
                res = (res + pow2[right - left]) % MOD;
                left++;
            } else {
                right--;
            }
        }

        return res;
    }

    /** Optional: Quick test */
    public static void main(String[] args) {
    }
}