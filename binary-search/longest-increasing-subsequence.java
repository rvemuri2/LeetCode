import java.util.*;

class Solution {
    /**
     * Returns the length of the Longest Increasing Subsequence (strictly increasing).
     * 
     * Idea (Patience Sorting / Tails array):
     * - tails[len] = the smallest possible tail value of any increasing subsequence of length (len+1).
     * - For each num, find its position in tails using binary search:
     *      - If num is larger than all tails, append it (we extended the LIS).
     *      - Otherwise, replace the first tail >= num (we keep tails as small as possible).
     * - The size of tails at the end is the LIS length.
     *
     * Time:  O(n log n)
     * Space: O(n)
     */
    public int lengthOfLIS(int[] nums) {
        // tails will be increasing; size tells how many valid entries we currently have
        int[] tails = new int[nums.length];
        int size = 0;

        for (int x : nums) {
            // Find the first index i in [0, size) where tails[i] >= x
            int lo = 0, hi = size;
            while (lo < hi) {
                int mid = (lo + hi) >>> 1;
                if (tails[mid] < x) lo = mid + 1;
                else hi = mid;
            }
            // lo is the place to put x
            tails[lo] = x;
            // If x extends the largest subsequence, increase size
            if (lo == size) size++;
        }

        return size;
    }

    // Quick harness with a few test cases
}