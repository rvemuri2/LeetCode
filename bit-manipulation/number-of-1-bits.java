class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);  // drops the lowest set bit
            count++;
        }
        return count;
    }

    // Test cases
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.hammingWeight(11));         // Output: 3 (binary: 1011)
        System.out.println(sol.hammingWeight(128));        // Output: 1 (binary: 10000000)
        System.out.println(sol.hammingWeight(2147483645)); // Output: 30 (binary: 111...1101)
    }
}