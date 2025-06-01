import java.util.*;

public class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int target = n * n;
        // visited[i] = true if we have already enqueued square i
        boolean[] visited = new boolean[target + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;
        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            // Process all squares reachable in 'moves' rolls
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                if (curr == target) return moves;
                // Try all die rolls 1..6
                for (int step = 1; step <= 6; step++) {
                    int nxt = curr + step;
                    if (nxt > target) break;
                    int[] rc = getRC(nxt, n);
                    int r = rc[0], c = rc[1];
                    // If there's a snake or ladder, jump to that destination
                    if (board[r][c] != -1) {
                        nxt = board[r][c];
                    }
                    if (!visited[nxt]) {
                        visited[nxt] = true;
                        queue.offer(nxt);
                    }
                }
            }
            moves++;
        }
        return -1;
    }

    // Map square s (1..n^2) to (row, col) in the 0-based board
    private int[] getRC(int s, int n) {
        int idx = s - 1;
        int row = n - 1 - (idx / n);
        int col;
        int baseRowFromBottom = (n - 1) - row;
        if (baseRowFromBottom % 2 == 0) {
            col = idx % n;
        } else {
            col = n - 1 - (idx % n);
        }
        return new int[]{row, col};
    }
}