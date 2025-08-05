class Solution {
    public int findDuplicate(int[] nums) {
        // Phase 1: Detect intersection point inside the cycle
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Phase 2: Find entrance to the cycle (duplicate number)
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    // Test cases
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] test1 = {1, 3, 4, 2, 2};
        System.out.println("Test 1 Output: " + sol.findDuplicate(test1)); // Expected: 2

        int[] test2 = {3, 1, 3, 4, 2};
        System.out.println("Test 2 Output: " + sol.findDuplicate(test2)); // Expected: 3

        int[] test3 = {3, 3, 3, 3, 3};
        System.out.println("Test 3 Output: " + sol.findDuplicate(test3)); // Expected: 3

        int[] test4 = {1, 1};
    }
}