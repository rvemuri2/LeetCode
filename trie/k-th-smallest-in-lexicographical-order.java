class Solution {
    /**
     */
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k--;              
        while (k > 0) {
            long steps = countSteps(n, curr, curr + 1);
            if (steps <= k) {
                k -= steps;
                curr++;
            } else {
                k--;
                curr *= 10;
            }
        }
        return curr;
    }
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