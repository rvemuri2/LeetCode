class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        // Binary search for a peak
        while (left < right) {
            int mid = left + (right - left) / 2;

            // If the current mid element is less than its right neighbor,
            // then the peak lies to the right of mid
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                // Else, the peak is at mid or to the left of mid
                right = mid;
            }
        }
        return left;
    }
}