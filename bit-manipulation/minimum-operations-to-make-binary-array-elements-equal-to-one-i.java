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

        // Check if last 2 elements are all 1s (otherwise we can't flip anymore)
        if (nums[n - 2] == 0 || nums[n - 1] == 0) {
            return -1;
        }

        return ops;
    }

    // Main method to test the function
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] test1 = {0, 1, 1, 1, 0, 0};
        int[] test2 = {0, 1, 1, 1};
        int[] test3 = {1, 1, 1, 1};

        System.out.println("Test 1 Result: " + sol.minOperations(test1)); // Expected: 3
        System.out.println("Test 2 Result: " + sol.minOperations(test2)); 
        System.out.println("Test 3 Result: " + sol.minOperations(test3));
    }
}