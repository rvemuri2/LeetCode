class Solution {
    public int[] shuffle(int[] nums, int n) {
        // Initialize result array of size 2n
        int[] result = new int[2 * n];
        int j = n;
        for (int i = 0; i < n; i++) {
            result[2 * i] = nums[i];
            result[2 * i + 1] = nums[j];
            j++;
        }

        return result;
    }
}