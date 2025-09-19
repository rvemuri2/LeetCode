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
}