class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    // Backtracking helper function
    private boolean solve(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                // If the current cell is empty
                if (board[row][col] == '.') {
                    // Try digits 1 to 9
                    for (char ch = '1'; ch <= '9'; ch++) {
                        if (isValid(board, row, col, ch)) {
                            board[row][col] = ch;
                            // Recur for the next cell
                            if (solve(board)) {
                                return true;
                            }
                            // Backtrack
                            board[row][col] = '.';
                        }
                    }
                    return false; // No valid digit found
                }
            }
        }
        return true; // All cells filled
    }

    // Check if placing 'ch' at board[row][col] is valid
    private boolean isValid(char[][] board, int row, int col, char ch) {
        for (int i = 0; i < 9; i++) {
            // Check row
            if (board[row][i] == ch) return false;
            // Check column
            if (board[i][col] == ch) return false;
            // Check 3x3 sub-box
            int boxRow = 3 * (row / 3) + i / 3;
            int boxCol = 3 * (col / 3) + i % 3;
            if (board[boxRow][boxCol] == ch) return false;
        }
        return true;
    }

    // For demonstration
    public static void main(String[] args) {
        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
        };
    }
}