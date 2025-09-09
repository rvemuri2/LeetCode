class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] C = new int[n];

        boolean[] seenA = new boolean[n + 1];
        boolean[] seenB = new boolean[n + 1];

        int commonSoFar = 0;

        for (int i = 0; i < n; i++) {
            int a = A[i];
            int b = B[i];

            if (!seenA[a]) {
                seenA[a] = true;
                if (seenB[a]) {
                    commonSoFar++;
                }
            }

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