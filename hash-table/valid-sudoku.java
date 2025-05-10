import java.util.*;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char val = board[r][c];
                if (val == '.') {
                    continue;
                };

                if (!rows[r].add(val)) {
                    return false;
                }

                if (!cols[c].add(val)) return false;

                int boxIndex = (r / 3) * 3 + (c / 3);
                if (!boxes[boxIndex].add(val)) return false;
            }
        }

        return true;
    }
}
