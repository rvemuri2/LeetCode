public class Solution {
    public int uniquePaths(int m, int n) {
        int N = m + n - 2;
        int k = Math.min(m - 1, n - 1);
        long res = 1;

        for (int i = 1; i <= k; i++) {
            res = res * (N - k + i) / i;
        }

        return (int) res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.uniquePaths(3, 7)); // 28
        System.out.println(sol.uniquePaths(3, 2)); // 3
        System.out.println(sol.uniquePaths(1, 1)); // 1
        System.out.println(sol.uniquePaths(10, 10)); // 48620
    }
}
