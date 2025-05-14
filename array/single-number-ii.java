public class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;

        // Check each bit position
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            int mask = 1 << i;

            for (int num : nums) {
                if ((num & mask) != 0) {
                    sum++;
                }
            }

            // If sum % 3 != 0, the unique number has a 1 in this bit position
            if (sum % 3 != 0) {
                result |= mask;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.singleNumber(new int[]{2, 2, 3, 2}));        // Output: 3
        System.out.println(sol.singleNumber(new int[]{0, 1, 0, 1, 0, 1, 99}));
    }
}
