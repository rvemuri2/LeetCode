class Solution {
    public long distributeCandies(int n, int limit) {
        // Total without any upper bound: C(n+2, 2)
        long total = f(n);
        int L = limit + 1;
        long sub1 = f(n - L);
        long sub2 = f(n - 2 * L);
        long sub3 = f(n - 3 * L);
        
        return total - 3 * sub1 + 3 * sub2 - sub3;
    }
    private long f(int t) {
        if (t < 0) return 0;
        long x = t + 2L;
        long y = t + 1L;
        return (x * y) / 2;
    }
}