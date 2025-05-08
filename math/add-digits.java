public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.addDigits(38)); // Output: 2
        System.out.println(sol.addDigits(0));  // Output: 0
        System.out.println(sol.addDigits(99)); // Output: 9
    }

    public int addDigits(int num) {
        if (num == 0) return 0;
        return 1 + (num - 1) % 9;
    }
}
