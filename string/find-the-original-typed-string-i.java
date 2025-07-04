import java.util.*;

class Solution {
    /**
     * Alice may have long-pressed a single key once, turning an intended run of length x
     * into a final run of length L ≥ x. Given the final word, count how many distinct
     * original words (without any extra long-presses) could produce it.
     *
     * At most one run was long-pressed.  If a run has final length L:
     *   – If it was never long-pressed, original length = L (contributes 1 possibility).
     *   – If it was long-pressed, original length could be any 1 ≤ x < L, giving (L–1) possibilities.
     * Summing over runs, we get:
     *   total = 1 (no long press anywhere) + ∑_{runs with L ≥ 2} (L – 1).
     */
    public int possibleStringCount(String word) {
        int n = word.length();
        int total = 1;
        
        int i = 0;
        while (i < n) {
            char c = word.charAt(i);
            int j = i;
            while (j < n && word.charAt(j) == c) {
                j++;
            }
            int runLen = j - i;
            if (runLen >= 2) {
                total += (runLen - 1);
            }
            i = j;
        }
        
        return total;
    }
}
