import java.util.Arrays;

class Solution {
    /**
     * Returns the prefix common array C where
     * C[i] = number of values that have appeared in A[0..i] and B[0..i].
     *
     * A and B are permutations of 1..n (no duplicates overall).
     * Time:  O(n)
     * Space: O(n)
     */
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] C = new int[n];

        // seenA[v] == true iff value v has appeared in A so far
        // seenB[v] == true iff value v has appeared in B so far
        boolean[] seenA = new boolean[n + 1]; // values are 1..n
        boolean[] seenB = new boolean[n + 1];

        int commonSoFar = 0;

        for (int i = 0; i < n; i++) {
            int a = A[i];
            int b = B[i];

            // Mark A[i]; if it was already seen in B, we've completed a "pair"
            if (!seenA[a]) {
                seenA[a] = true;
                if (seenB[a]) commonSoFar++;
            }

            // Mark B[i]; if it was already seen in A, we've completed a "pair"
            // Note: even if a == b, this increments at most once overall:
            if (!seenB[b]) {
                seenB[b] = true;
                if (seenA[b]) {
                    commonSoFar++;
                }
            }

            C[i] = commonSoFar;
        }

        return C;
    }
}