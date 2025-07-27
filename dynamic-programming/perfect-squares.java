import java.util.*;

class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // Base case

        // Precompute all perfect squares less than or equal to n
        List<Integer> squares = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            squares.add(i * i);
        }

        for (int i = 1; i <= n; i++) {
            for (int square : squares) {
                if (i < square) break;
                dp[i] = Math.min(dp[i], dp[i - square] + 1);
            }
        }

        return dp[n];
    }

    // Sample test cases
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Test Case 1 (n=12): " + sol.numSquares(12)); // Output: 3 (4+4+4)
        System.out.println("Test Case 2 (n=13): " + sol.numSquares(13)); // Output: 2 (4+9)
        System.out.println("Test Case 3 (n=1): " + sol.numSquares(1));   // Output: 1 (1)
    }
}
