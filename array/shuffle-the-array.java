class Solution {
    public int[] shuffle(int[] nums, int n) {
        // Initialize result array of size 2n
        int[] result = new int[2 * n];

        // Use two pointers: i for x's (0..n-1) and j for y's (n..2n-1)
        int j = n;
        for (int i = 0; i < n; i++) {
            // Place xi at even indices and yi at odd indices
            result[2 * i] = nums[i];
            result[2 * i + 1] = nums[j];
            j++;
        }

        return result;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {2,5,1,3,4,7};
        int[] res1 = sol.shuffle(nums1, 3);
    }
}