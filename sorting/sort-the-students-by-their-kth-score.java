import java.util.*;

/**
 * Sort the rows (students) by their score in column k in DESC order.
 */
class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        final int kk = k;
        Arrays.sort(score, (a, b) -> Integer.compare(b[kk], a[kk]));
        return score;
    }
}
