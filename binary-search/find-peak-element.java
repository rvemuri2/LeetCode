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
        Solution sol = new Solution();
        System.out.println(sol.findPeakElement(new int[]{1, 2, 3, 1}));        // Output: 2
        System.out.println(sol.findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4})); // Output: 5 or 1
        System.out.println(sol.findPeakElement(new int[]{3}));                 // Output: 0
        System.out.println(sol.findPeakElement(new int[]{1, 2}));              // Output: 1
        System.out.println(sol.findPeakElement(new int[]{2, 1}));
    }
}