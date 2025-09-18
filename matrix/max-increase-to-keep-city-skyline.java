import java.util.*;

public class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int[] rowMax = new int[n];
        int[] colMax = new int[n];

        // Compute row and column skylines
        for (int i = 0; i < n; i++) {
            int rm = 0;
            for (int j = 0; j < n; j++) {
                rm = Math.max(rm, grid[i][j]);
            }
            rowMax[i] = rm;
        }
        for (int j = 0; j < n; j++) {
            int cm = 0;
            for (int i = 0; i < n; i++) {
                cm = Math.max(cm, grid[i][j]);
            }
            colMax[j] = cm;
        }

        // Sum allowed increases
        int total = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int allowed = Math.min(rowMax[i], colMax[j]);
                if (allowed > grid[i][j]) {
                    total += allowed - grid[i][j];
                }
            }
        }
        return total;
    }

    // --- Test harness ---
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] g1 = {
            {3,0,8,4},
            {2,4,5,7},
            {9,2,6,3},
            {0,3,1,0}
        };
        System.out.println("Example 1: " + sol.maxIncreaseKeepingSkyline(g1)); // 35

        int[][] g2 = {
            {0,0,0},
            {0,0,0},
            {0,0,0}
        };
        System.out.println("Example 2: " + sol.maxIncreaseKeepingSkyline(g2)); // 0

        // Additional tests
        int[][] g3 = {
            {1,2},
            {3,4}
        };
        // rowMax = [2,4], colMax = [3,4]
        // allowed grid = [[min(2,3)=2, min(2,4)=2], [min(4,3)=3, min(4,4)=4]]
        // increases = (2-1)+(2-2)+(3-3)+(4-4)=1
        System.out.println("Test 3: " + sol.maxIncreaseKeepingSkyline(g3)); // 1
    }
}