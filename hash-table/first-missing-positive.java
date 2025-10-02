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

    }
}