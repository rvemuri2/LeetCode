class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0;
        int right = nums.length - 1;

        while (l < right) {
            int mid = l + (right - l) / 2;
            if (nums[mid] < nums[mid + 1]) {
                l = mid + 1;
            } else {
                right = mid;
            }
        }
        return l;
    }
}