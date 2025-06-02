class Solution {
    public long distributeCandies(int n, int limit) {
        // Total without any upper bound: C(n+2, 2)
        long total = f(n);
        
        // Using inclusion–exclusion to subtract distributions
        // where at least one child exceeds 'limit'
        int L = limit + 1;
        long sub1 = f(n - L);            // one child > limit
        long sub2 = f(n - 2 * L);        // two children > limit
        long sub3 = f(n - 3 * L);        // all three > limit
        
        return total - 3 * sub1 + 3 * sub2 - sub3;
    }
    private long f(int t) {
        if (t < 0) return 0;
        long x = t + 2L;
        long y = t + 1L;
        return (x * y) / 2;
    }
}