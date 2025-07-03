class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;

        // Calculate expected sum from 0 to n
        int expectedSum = n * (n + 1) / 2;

        // Calculate actual sum of nums
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }

        // The missing number is the difference
        return expectedSum - actualSum;
    }

    // Test examples
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {3,0,1};
        System.out.println(sol.missingNumber(nums1)); // Output: 2
    }
}