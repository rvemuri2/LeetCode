class Solution {
    /**
     * Returns the maximum absolute difference between adjacent elements
     * in a circular array. The first and last elements are also considered adjacent.
     *
     */
    public int maxAdjacentDistance(int[] nums) {
        int maxDiff = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int nextIndex = (i + 1) % n;
            int diff = Math.abs(nums[i] - nums[nextIndex]);
            maxDiff = Math.max(maxDiff, diff);
        }
        return maxDiff;
    }
}