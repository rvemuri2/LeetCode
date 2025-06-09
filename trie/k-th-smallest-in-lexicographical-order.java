class Solution {
    /**
     * Returns the k-th smallest number in lexicographical order among [1..n].
     * Uses a prefix‐tree (trie) counting approach in O(log n * 10) time.
     */
    public int findKthNumber(int n, int k) {
        int curr = 1;       // current prefix (first in lex order is "1")
        k--;                // we've "used up" the 1st position
        while (k > 0) {
            long steps = countSteps(n, curr, curr + 1);
            if (steps <= k) {
                // skip this entire subtree and move to next sibling
                k -= steps;
                curr++;
            } else {
                // descend into this subtree: the prefix itself is the next
                k--;
                curr *= 10;
            }
        }
        return curr;
    }

    /**
     * Count how many numbers x in [1..n] have a prefix between first (inclusive)
     * and next (exclusive). We sum over all levels by multiplying first/next by 10.
     */
    private long countSteps(int n, long first, long next) {
        long steps = 0;
        while (first <= n) {
            steps += Math.min(n + 1, next) - first;
            first *= 10;
            next *= 10;
        }
        return steps;
    }
}