class Solution {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;

        Deque<int[]> q = new ArrayDeque<>();

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