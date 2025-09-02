import java.util.*;

/**
 * Sort the rows (students) by their score in column k in DESC order.
 */
class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        // Sort in-place by the kth exam descending.
        final int kk = k; // effectively final for the lambda
        Arrays.sort(score, (a, b) -> Integer.compare(b[kk], a[kk]));
        return score;
        // If you needed to keep the original matrix, clone before sorting.
        // int[][] copy = Arrays.stream(score).map(int[]::clone).toArray(int[][]::new);
        // Arrays.sort(copy, (a, b) -> Integer.compare(b[kk], a[kk]));
        // return copy;
    }

    // ---------- Demo ----------
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] score1 = { {10,6,9,1}, {7,5,11,2}, {4,8,3,15} };
        int k1 = 2;
        System.out.println("Example 1 input: " + Arrays.deepToString(score1) + ", k=" + k1);
        int[][] ans1 = sol.sortTheStudents(score1, k1);
        System.out.println("Output: " + Arrays.deepToString(ans1));
        // Expected: [[7,5,11,2],[10,6,9,1],[4,8,3,15]]

        int[][] score2 = { {3,4}, {5,6} };
        int k2 = 0;
        System.out.println("\nExample 2 input: " + Arrays.deepToString(score2) + ", k=" + k2);
        int[][] ans2 = sol.sortTheStudents(score2, k2);
        System.out.println("Output: " + Arrays.deepToString(ans2));
        // Expected: [[5,6],[3,4]]

        // A couple of extra quick tests
    }
}
