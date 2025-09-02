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
    }
}
