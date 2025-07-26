import java.util.Arrays;

class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;

        for (int i = 0; i < n; i++) {
            int h = n - i; // Number of papers with at least citations[i] citations
            if (citations[i] >= h) {
                return h;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Test Case 1: " + sol.hIndex(new int[]{3, 0, 6, 1, 5})); // Output: 3
        System.out.println("Test Case 2: " + sol.hIndex(new int[]{1, 3, 1}));       // Output: 1
        System.out.println("Test Case 3: " + sol.hIndex(new int[]{0, 0, 0}));       // Output: 0
        System.out.println("Test Case 4: " + sol.hIndex(new int[]{10, 8, 5, 4, 3})); // Output: 4
        System.out.println("Test Case 5: " + sol.hIndex(new int[]{100}));           // Output: 1
        System.out.println("Test Case 6: " + sol.hIndex(new int[]{0}));             // Output: 0
    }
}
