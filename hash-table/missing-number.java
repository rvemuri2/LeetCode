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
        return expectedSum - actualSum;
    }
}