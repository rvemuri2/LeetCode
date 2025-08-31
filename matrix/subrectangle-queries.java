import java.util.*;

class SubrectangleQueries {
    private final int[][] rect; // mutable copy we will update in-place

    /**
     * Store a deep copy of the initial rectangle so we can mutate safely.
     */
    public SubrectangleQueries(int[][] rectangle) {
        int r = rectangle.length, c = rectangle[0].length;
        rect = new int[r][c];
        for (int i = 0; i < r; i++) {
            System.arraycopy(rectangle[i], 0, rect[i], 0, c);
        }
    }

    /**
     * Update every cell in the sub-rectangle [row1..row2] x [col1..col2] to newValue.
     * Time: O((row2-row1+1)*(col2-col1+1)) which is fine for constraints (<= 10^4 per update).
     */
    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for (int r = row1; r <= row2; r++) {
            for (int c = col1; c <= col2; c++) {
                rect[r][c] = newValue;
            }
        }
    }

    /**
     * Return current value at (row, col). O(1).
     */
    public int getValue(int row, int col) {
        return rect[row][col];
    }
}

/* -------------------- Small demo --------------------
class Main {
    public static void main(String[] args) {
        SubrectangleQueries sq = new SubrectangleQueries(new int[][]{
            {1,2,1},
            {4,3,4},
------------------------------------------------------ */


/**
 * Your SubrectangleQueries object will be instantiated and called as such:
 * SubrectangleQueries obj = new SubrectangleQueries(rectangle);
 * obj.updateSubrectangle(row1,col1,row2,col2,newValue);
 * int param_2 = obj.getValue(row,col);
 */