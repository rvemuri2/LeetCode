class NumArray {
    private int[] prefixSums;

    public NumArray(int[] nums) {
        // Initialize prefix sum array
        prefixSums = new int[nums.length + 1];
        prefixSums[0] = 0; // prefixSums[0] is 0 for ease of calculation

        // Compute prefix sums: prefixSums[i] = sum of first i elements
        for (int i = 0; i < nums.length; i++) {
            prefixSums[i + 1] = prefixSums[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        // The sum from left to right is prefix[right+1] - prefix[left]
        return prefixSums[right + 1] - prefixSums[left];
    }

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[] {-2, 0, 3, -5, 2, -1});
        System.out.println(numArray.sumRange(0, 2));
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */