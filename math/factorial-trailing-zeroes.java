class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        
        // Count multiples of 5, 25, 125, etc.
        while (n > 0) {
            n /= 5;        // Reduce n by dividing with 5
            count += n;    // Add number of factors of 5 found
        }
        
        return count;
    }

    // Main method with test cases
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println(sol.trailingZeroes(3));   // Output: 0 (3! = 6)
        System.out.println(sol.trailingZeroes(5));   // Output: 1 (5! = 120)
        System.out.println(sol.trailingZeroes(10));  // Output: 2 (10! = 3628800)
        System.out.println(sol.trailingZeroes(25));  // Output: 6 (25! has 6 zeros)
        System.out.println(sol.trailingZeroes(100)); // Output: 24
    }
}
