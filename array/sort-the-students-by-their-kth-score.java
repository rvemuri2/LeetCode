class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        final int kk = k;
        Arrays.sort(score, (a, b) -> Integer.compare(b[kk], a[kk]));
        return score;
    }
}
