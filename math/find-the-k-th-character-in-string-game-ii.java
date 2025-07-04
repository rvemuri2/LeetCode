class Solution {
    public char kthCharacter(long k, int[] operations) {
        int m = operations.length;
        // 1) Compute lengths after each operation
        long[] len = new long[m + 1];
        len[0] = 1;  // initial word = "a"
        for (int i = 0; i < m; i++) {
            // both op 0 and op 1 double the length
            len[i + 1] = len[i] * 2;
            // we are guaranteed len[i+1] >= k at the end
        }

        // 2) Walk backwards, mapping k into the original half
        int shiftCount = 0;  // total shifts from type-1 second-half selections
        for (int i = m - 1; i >= 0; i--) {
            long half = len[i];
            if (k > half) {
                // k landed in the appended half
                k -= half;
                if (operations[i] == 1) {
                    // that half was a shifted copy → record one shift
                    shiftCount++;
                }
            }
            // else k stays the same, in the first half
        }

        // 3) At this point k must be 1, picking from the original "a"
        // Apply all recorded shifts mod 26
        int shift = shiftCount % 26;
        char ans = (char) ('a' + shift);
        return ans;
    }

    // Quick tests
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.kthCharacter(5,  new int[]{0,0,0}));    // a
        System.out.println(sol.kthCharacter(10, new int[]{0,1,0,1})); // b
        System.out.println(sol.kthCharacter(1,  new int[]{1,1,1,1})); // e  ("a"→"ab"→"bcc"→ …)
    }
}