class Solution {
    public char kthCharacter(long k, int[] operations) {
        int m = operations.length;
        // 1) Build len[], but cap each at k (no need to track lengths beyond k)
        long[] len = new long[m + 1];
        len[0] = 1;
        for (int i = 0; i < m; i++) {
            // both op 0 and op 1 double the length
            len[i + 1] = Math.min(len[i] * 2, k);
        }

        // 2) Walk backwards, mapping k back to the original 'a'
        int shiftCount = 0;
        for (int i = m - 1; i >= 0; i--) {
            long half = len[i];
            if (k > half) {
                // k is in the appended half
                k -= half;
                if (operations[i] == 1) {
                    // appended half was the shifted copy
                    shiftCount = (shiftCount + 1) % 26;
                }
            }
            // else k remains in [1..half]
        }

        // 3) After unwinding all doublings, k must be 1 (the single 'a')
        // Apply total shifts
        char ans = (char) ('a' + shiftCount);
        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        // Provided tests
    }
}