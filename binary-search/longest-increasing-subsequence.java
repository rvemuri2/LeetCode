import java.util.*;

class Solution {
    /**
     * Returns the length of the Longest Increasing Subsequence (strictly increasing).
     * 
     * Idea (Patience Sorting / Tails array):
     * - tails[len] = the smallest possible tail value of any increasing subsequence of length (len+1).
     * - For each num, find its position in tails using binary search:
     *      - If num is larger than all tails, append it (we extended the LIS).
     */
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;

        for (int x : nums) {
            int lo = 0, hi = size;
            while (lo < hi) {
                int mid = (lo + hi) >>> 1;
                if (tails[mid] < x) {
                     lo = mid + 1;
                }
                else {
                    hi = mid;
                }
            }
            tails[lo] = x;
            if (lo == size) {
                size++;
            }
        }

        return size;
    }
}