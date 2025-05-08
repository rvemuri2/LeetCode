public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.isUgly(6));   // true
        System.out.println(sol.isUgly(1));   // true
        System.out.println(sol.isUgly(14));  // false
        System.out.println(sol.isUgly(0));   // false
        System.out.println(sol.isUgly(30));  // true
    }

    public boolean isUgly(int n) {
        // 0 or negative numbers are not ugly
        if (n <= 0) return false;

        // Divide out all factors of 2, 3, and 5
        for (int factor : new int[]{2, 3, 5}) {
            while (n % factor == 0) {
                n /= factor;
            }
        }

        return n == 1;
    }
}
