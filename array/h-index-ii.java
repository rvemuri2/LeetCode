class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int left = 0, right = n - 1;
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int h = n - mid;

            if (citations[mid] >= h) {
                result = h;
                right = mid - 1; // try for a better (smaller) index
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Test Case 1: " + sol.hIndex(new int[]{0, 1, 3, 5, 6}));  // Output: 3
        System.out.println("Test Case 2: " + sol.hIndex(new int[]{1, 2, 100}));      // Output: 2
        System.out.println("Test Case 3: " + sol.hIndex(new int[]{0, 0, 0}));        // Output: 0
        System.out.println("Test Case 4: " + sol.hIndex(new int[]{100, 200, 300}));  // Output: 3
        System.out.println("Test Case 5: " + sol.hIndex(new int[]{0}));              // Output: 0
    }
}
