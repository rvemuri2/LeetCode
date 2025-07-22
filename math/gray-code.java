import java.util.*;

class Solution {
    /**
     * Generates an n-bit Gray code sequence.
     * @param n number of bits
     * @return List of integers representing the Gray code sequence
     */
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        int total = 1 << n; // 2^n values

        for (int i = 0; i < total; i++) {
            result.add(i ^ (i >> 1)); // Gray code formula
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // ✅ Test Cases
        System.out.println("n = 1 → " + sol.grayCode(1)); // [0, 1]
        System.out.println("n = 2 → " + sol.grayCode(2));
    }
}