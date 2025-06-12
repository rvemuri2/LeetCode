class Solution {
    /**
     * Returns the maximum absolute difference between adjacent elements
     * in a circular array. The first and last elements are also considered adjacent.
     *
     * @param nums the input circular array
     * @return the maximum absolute difference between adjacent elements
     */
    public int maxAdjacentDistance(int[] nums) {
        int maxDiff = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // Get the next index in a circular way
            int nextIndex = (i + 1) % n;
            int diff = Math.abs(nums[i] - nums[nextIndex]);
            maxDiff = Math.max(maxDiff, diff);
        }

        return maxDiff;
    }

    // Example usage and test cases
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] test1 = {1, 2, 4};
    }
}