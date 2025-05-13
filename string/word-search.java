public class Solution {
    private int rows, cols;
    private char[][] board;
    private String word;

    public boolean exist(char[][] board, String word) {
        this.rows = board.length;
        this.cols = board[0].length;
        this.board = board;
        this.word = word;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(int row, int col, int index) {
        // Out of bounds or character doesn't match
        if (row < 0 || col < 0 || row >= rows || col >= cols || board[row][col] != word.charAt(index)) {
            return false;
        }

        // Entire word matched
        if (index == word.length() - 1) return true;

        // Mark the cell as visited
        char temp = board[row][col];
        board[row][col] = '#';

        // Explore in 4 directions
        boolean found = dfs(row + 1, col, index + 1) ||
                        dfs(row - 1, col, index + 1) ||
                        dfs(row, col + 1, index + 1) ||
                        dfs(row, col - 1, index + 1);

        // Restore the cell
        board[row][col] = temp;

        return found;
    }

    // Test driver
    public static void main(String[] args) {
        Solution sol = new Solution();

        char[][] board = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };

        System.out.println(sol.exist(board, "ABCCED")); // true
    }
}
