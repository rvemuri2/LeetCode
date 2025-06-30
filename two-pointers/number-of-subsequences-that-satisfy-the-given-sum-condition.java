import java.util.Arrays;

class Solution {
    public int numSubseq(int[] nums, int target) {

        int MOD = 1000000007;
        int n = nums.length;
        Arrays.sort(nums);

        int[] pow2 = new int[n];
        pow2[0] = 1;
        for (int i = 1; i < n; i++) {
            pow2[i] = (pow2[i - 1] * 2) % MOD;
        }

        int left = 0;
        int right = n - 1;
        int res = 0;

        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                res = (res + pow2[right - left]) % MOD;
                left++;
            } else {
                right--;
            }
        }

        return res;
    }
}