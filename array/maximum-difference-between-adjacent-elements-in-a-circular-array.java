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
        System.out.println("Expected: 3, Got: " + sol.maxAdjacentDistance(test1));

        int[] test2 = {-5, -10, -5};
        System.out.println("Expected: 5, Got: " + sol.maxAdjacentDistance(test2));

        int[] test3 = {100, -100, 50};
        System.out.println("Expected: 200, Got: " + sol.maxAdjacentDistance(test3));

        int[] test4 = {0, 0};
        System.out.println("Expected: 0, Got: " + sol.maxAdjacentDistance(test4));

        int[] test5 = {10, 5, 15, 5};
        System.out.println("Expected: 10, Got: " + sol.maxAdjacentDistance(test5));
    }
}