class Solution {
    // Core method to return the minimum operations or -1 if impossible
    public int minOperations(int[] nums) {
        int n = nums.length;
        int ops = 0;

        // Traverse left to right
        for (int i = 0; i <= n - 3; i++) {
            if (nums[i] == 0) {
                // Flip the 3 consecutive bits
                nums[i] ^= 1;
                nums[i + 1] ^= 1;
                nums[i + 2] ^= 1;
                ops++;
            }
        }
        if (nums[n - 2] == 0 || nums[n - 1] == 0) {
            return -1;
        }

        return ops;
    }
}