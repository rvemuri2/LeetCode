import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // Sort the array to use two pointers
        Arrays.sort(nums);
        int n = nums.length;

        // Initialize result with a very large value
        int closestSum = nums[0] + nums[1] + nums[2];

        // Iterate through the array
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            // Use two pointers to find the best pair
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                // Update closestSum if this sum is closer to target
                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                }

                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    return sum;
                }
            }
        }

        return closestSum;
    }
}