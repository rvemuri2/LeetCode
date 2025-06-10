import java.util.*;

class Solution {
    /**
     * Calculates the maximum difference between frequencies of characters a1 - a2
     * such that:
     * - a1 has odd frequency
     * - a2 has even frequency
     */
    public int maxDifference(String s) {
        int[] freq = new int[26]; // To store frequencies of all lowercase letters

        // Count frequency of each character
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int maxOdd = Integer.MIN_VALUE;
        int minEven = Integer.MAX_VALUE;

        // Loop through frequencies and track:
        for (int f : freq) {
            if (f == 0) {
                continue;
            }
            if (f % 2 == 1) {
                maxOdd = Math.max(maxOdd, f);
            } else {
                minEven = Math.min(minEven, f);
            }
        }
        return maxOdd - minEven;
    }
}
