public class Solution {
    public int minFlipsToAllOnes(int[] nums) {
        int n = nums.length;
        int flips = 0;

        for (int i = 0; i <= n - 3; i++) {
            if (nums[i] == 0) {
                // Flip nums[i], nums[i+1], nums[i+2]
                nums[i] ^= 1;
                nums[i+1] ^= 1;
                nums[i+2] ^= 1;
                flips++;
            }
        }

        // Check if last two elements are 1
        for (int i = n - 2; i < n; i++) {
            if (i >= 0 && nums[i] == 0) return -1;
        }

        return flips;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.minFlipsToAllOnes(new int[]{0,1,1,1,0,0})); // Output: 3
        System.out.println(sol.minFlipsToAllOnes(new int[]{0,1,1,1}));     // Output: -1
        System.out.println(sol.minFlipsToAllOnes(new int[]{1,1,1,1,1}));   // Output: 0
    }
}