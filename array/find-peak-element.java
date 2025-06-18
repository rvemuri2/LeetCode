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

        // At the end, left == right, which will be the index of a peak element
        return left;
    }
    // Test cases
    public static void main(String[] args) {
    }
}