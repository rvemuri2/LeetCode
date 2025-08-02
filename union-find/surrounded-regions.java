import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    /**
     * Surrounded Regions (BFS version, O(m*n) time, O(m*n) space)
     *
     * Idea:
     * 1) Any 'O' that is connected to the border (top row, bottom row, left col, right col)
     *    cannot be captured. We'll mark all such 'O's as SAFE by traversing from the border.
     * 2) After marking, any remaining 'O' is surrounded -> flip it to 'X'.
     * 3) Turn all SAFE marks back to 'O'.
     *
     * We do the marking using BFS to avoid deep recursion.
     */
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;

        // Helper to enqueue a cell if it's an 'O'
        Deque<int[]> q = new ArrayDeque<>();

        // Enqueue all 'O's on the border and mark them as SAFE ('S').
        // Top and bottom rows
        for (int c = 0; c < n; c++) {
            if (board[0][c] == 'O') {
                board[0][c] = 'S';
                q.offer(new int[]{0, c});
            }
            if (board[m - 1][c] == 'O') {
                board[m - 1][c] = 'S';
                q.offer(new int[]{m - 1, c});
            }
        }
        // Left and right columns
        for (int r = 0; r < m; r++) {
            if (board[r][0] == 'O') {
                board[r][0] = 'S';
                q.offer(new int[]{r, 0});
            }
            if (board[r][n - 1] == 'O') {
                board[r][n - 1] = 'S';
                q.offer(new int[]{r, n - 1});
            }
        }

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0], c = cell[1];
            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && board[nr][nc] == 'O') {
                    board[nr][nc] = 'S';
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                } else if (board[r][c] == 'S') {
                    board[r][c] = 'O'; 
                }
            }
        }
    }
}