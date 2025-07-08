class Solution {
    /**
     * Find the town judge:
     * - Judge trusts nobody  => outDegree[j] == 0
     * - Everybody else trusts judge => inDegree[j] == n-1
     */
    public int findJudge(int n, int[][] trust) {
        int[] inDegree = new int[n + 1];
        int[] outDegree = new int[n + 1];

        for (int[] t : trust) {
            int a = t[0], b = t[1];
            outDegree[a]++;
            inDegree[b]++;
        }
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == n - 1 && outDegree[i] == 0)
                return i;
        }
        return -1;
    }
}