class Solution {
    public boolean canWinNim(int n) {
        // You lose only when n is divisible by 4
        return n % 4 != 0;
    }

    // Example test cases
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.canWinNim(4));  // false
    }
}