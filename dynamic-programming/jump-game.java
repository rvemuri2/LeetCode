public class Solution {
    public boolean canJump(int[] nums) {
        int reachable = 0;  // Furthest index we can currently reach

        for (int i = 0; i < nums.length; i++) {
            if (i > reachable) {
                // If the current index is beyond the furthest we can reach
                return false;
            }
            reachable = Math.max(reachable, i + nums[i]);
        }

        return true; // We made it through the array
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(sol.canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(sol.canJump(new int[]{0}));
        System.out.println(sol.canJump(new int[]{2, 0, 0}));
    }
}
