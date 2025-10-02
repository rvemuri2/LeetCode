class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Place each number in its right place: nums[i] should be i+1
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // Swap nums[i] with nums[nums[i]-1]
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }

        // Find the first index where nums[i] != i+1
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // If all positions are filled correctly, answer is n+1
        return n + 1;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test cases
        int[] nums1 = {1, 2, 0};
        System.out.println("Expected: 3, Got: " + sol.firstMissingPositive(nums1));

        int[] nums2 = {3, 4, -1, 1};
        System.out.println("Expected: 2, Got: " + sol.firstMissingPositive(nums2));

        int[] nums3 = {7, 8, 9, 11, 12};
        System.out.println("Expected: 1, Got: " + sol.firstMissingPositive(nums3));

        int[] nums4 = {1, 2, 3, 4, 5};
        System.out.println("Expected: 6, Got: " + sol.firstMissingPositive(nums4));

        int[] nums5 = {2};
        System.out.println("Expected: 1, Got: " + sol.firstMissingPositive(nums5));


    }
}