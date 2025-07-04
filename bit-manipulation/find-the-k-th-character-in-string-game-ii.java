class Solution {
    public char kthCharacter(long k, int[] operations) {
        int m = operations.length;
        long[] len = new long[m + 1];
        len[0] = 1;
        for (int i = 0; i < m; i++) {
            len[i + 1] = Math.min(len[i] * 2, k);
        }

        int shiftCount = 0;
        for (int i = m - 1; i >= 0; i--) {
            long half = len[i];
            if (k > half) {
                k -= half;
                if (operations[i] == 1) {
                    shiftCount = (shiftCount + 1) % 26;
                }
            }
        }
        char ans = (char) ('a' + shiftCount);
        return ans;
    }
}