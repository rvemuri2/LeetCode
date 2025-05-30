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
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int row, int col, int index) {
        if (row < 0 || col < 0 || row >= rows || col >= cols || board[row][col] != word.charAt(index)) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        char temp = board[row][col];
        board[row][col] = '#';
        boolean found = dfs(row + 1, col, index + 1) ||
                        dfs(row - 1, col, index + 1) ||
                        dfs(row, col + 1, index + 1) ||
                        dfs(row, col - 1, index + 1);
        board[row][col] = temp;
        return found;
    }

}
