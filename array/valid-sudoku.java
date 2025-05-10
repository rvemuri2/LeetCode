import java.util.*;

public class Solution {
    public static void main(String[] args) {
        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };

        Solution sol = new Solution();
        System.out.println(sol.isValidSudoku(board)); // Output: true
    }

    public boolean isValidSudoku(char[][] board) {
        // Create sets for rows, columns, and boxes
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        // Traverse the board
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char val = board[r][c];
                if (val == '.') continue;

                // Check row
                if (!rows[r].add(val)) return false;

                if (!cols[c].add(val)) return false;

                int boxIndex = (r / 3) * 3 + (c / 3);
                if (!boxes[boxIndex].add(val)) return false;
            }
        }

        return true;
    }
}
