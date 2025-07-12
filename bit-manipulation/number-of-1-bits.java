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

        System.out.println(sol.hammingWeight(11));
    }
}