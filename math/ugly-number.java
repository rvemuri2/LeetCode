public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isUgly(6));
        System.out.println(sol.isUgly(1));
        System.out.println(sol.isUgly(14));
    }
    public boolean isUgly(int n) {
        if (n <= 0) return false;
        for (int factor : new int[]{2, 3, 5}) {
            while (n % factor == 0) {
                n /= factor;
            }
        }
        return n == 1;
    }
}