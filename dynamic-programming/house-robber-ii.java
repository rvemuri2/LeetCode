class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        int a = robLinear(nums, 0, n - 2);
        int b = robLinear(nums, 1, n - 1);
        return Math.max(a, b);
    }
    private int robLinear(int[] nums, int lo, int hi) {
        int prev2, prev1 = 0, 0;
        for (int i = lo; i <= hi; i++) {
            int pick = prev2 + nums[i];
            int skip = prev1;
            int cur = Math.max(pick, skip);
            prev2 = prev1;
            prev1 = cur;
        }
        return prev1;
    }
}