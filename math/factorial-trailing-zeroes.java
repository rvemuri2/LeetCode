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
    }
}