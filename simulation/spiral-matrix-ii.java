class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int num = 1;
        int max = n * n;
        int top = 0;
        int bottom = n - 1, left = 0, right = n - 1;

        while (top <= bottom && left <= right) {
            for (int c = left; c <= right && num <= max; c++) ans[top][c] = num++;
            top++;

            for (int r = top; r <= bottom && num <= max; r++) 
                ans[r][right] = num++;
            right--;

            if (top <= bottom) {
                for (int c = right; c >= left && num <= max; c--) {
                    ans[bottom][c] = num++;
                }
                bottom--;
            }

            if (left <= right) {
                for (int r = bottom; r >= top && num <= max; r--) {
                    ans[r][left] = num++;
                }
                left++;
            }
        }
        return ans;
    }
}