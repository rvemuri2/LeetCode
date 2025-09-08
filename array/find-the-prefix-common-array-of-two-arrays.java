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
            //   - when processing 'a', seenB[a] is still false (unless it appeared earlier),
            //   - when processing 'b', seenA[b] is true just marked, so it increments once.
            if (!seenB[b]) {
                seenB[b] = true;
                if (seenA[b]) commonSoFar++;
            }

            C[i] = commonSoFar;
        }

        return C;
    }

    // -------------------------
    // Simple test harness below
    // -------------------------
    public static void main(String[] args) {
        Solution s = new Solution();

        // Example 1
        int[] A1 = {1, 3, 2, 4};
        int[] B1 = {3, 1, 2, 4};
        System.out.println("Ex1: " + Arrays.toString(s.findThePrefixCommonArray(A1, B1)));
        // Expected: [0, 2, 3, 4]

        // Example 2
        int[] A2 = {2, 3, 1};
        int[] B2 = {3, 1, 2};
        System.out.println("Ex2: " + Arrays.toString(s.findThePrefixCommonArray(A2, B2)));
        // Expected: [0, 1, 3]

        // Edge-ish: n = 1
        int[] A3 = {1};
        int[] B3 = {1};
        System.out.println("n=1 same: " + Arrays.toString(s.findThePrefixCommonArray(A3, B3)));
        // Expected: [1]

        // Same arrays (C should be 1..n)
        int[] A4 = {4, 1, 3, 2, 5};
        int[] B4 = {4, 1, 3, 2, 5};
    }
}