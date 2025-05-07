import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.generate(5));
        System.out.println(sol.generate(1));
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        // Build each row one by one
        for (int row = 0; row < numRows; row++) {
            List<Integer> currentRow = new ArrayList<>();

            // First and last elements of each row are always 1
            currentRow.add(1);

            // Fill in the inner elements of the row (if row >= 2)
            for (int col = 1; col < row; col++) {
                int prevRowLeft = triangle.get(row - 1).get(col - 1);
                int prevRowRight = triangle.get(row - 1).get(col);
                currentRow.add(prevRowLeft + prevRowRight);
            }

            if (row > 0) {
                currentRow.add(1);
            }

            triangle.add(currentRow);
        }

        return triangle;
    }
}
