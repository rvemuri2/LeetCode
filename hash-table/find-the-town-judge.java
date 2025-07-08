class Solution {
    /**
     * Find the town judge:
     * - Judge trusts nobody  => outDegree[j] == 0
     * - Everybody else trusts judge => inDegree[j] == n-1
     */
    public int findJudge(int n, int[][] trust) {
        int[] inDegree = new int[n + 1];
        int[] outDegree = new int[n + 1];

        // Build degrees
        for (int[] t : trust) {
            int a = t[0], b = t[1];
            outDegree[a]++;
            inDegree[b]++;
        }

        // Find person with inDegree == n-1 and outDegree == 0
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == n - 1 && outDegree[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    // Simple tests
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.findJudge(2, new int[][]{{1,2}}));            // 2
        System.out.println(sol.findJudge(3, new int[][]{{1,3},{2,3}}));      // 3
        System.out.println(sol.findJudge(3, new int[][]{{1,3},{2,3},{3,1}}));
    }
}