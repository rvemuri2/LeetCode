import java.util.*;

class SubrectangleQueries {
    private final int[][] rect; // mutable copy we will update in-place

    /**
     */
    public SubrectangleQueries(int[][] rectangle) {
        int r = rectangle.length, c = rectangle[0].length;
        rect = new int[r][c];
        for (int i = 0; i < r; i++) {
            System.arraycopy(rectangle[i], 0, rect[i], 0, c);
        }
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for (int r = row1; r <= row2; r++) {
            for (int c = col1; c <= col2; c++) {
                rect[r][c] = newValue;
            }
        }
    }

    public int getValue(int row, int col) {
        return rect[row][col];
    }
}