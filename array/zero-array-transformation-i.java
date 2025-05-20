public class Solution {

    /**
     * Determines if it is possible to transform the given nums array into a zero array
     * using the provided range queries. Each query allows decrementing any subset of
     * values within the specified range by 1.
     *
     * @param nums    The initial array of non-negative integers.
     * @param queries The list of queries, each representing a [li, ri] range.
     */
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1];

        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];

            diff[l] += 1;
            if (r + 1 < n) {
                diff[r + 1] -= 1;
            }
        }
        int[] coverage = new int[n];
        int curr = 0;
        for (int i = 0; i < n; i++) {
            curr += diff[i];
            coverage[i] = curr;
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > coverage[i]) {
                return false;
            }
        }

        return true;
    }
}
