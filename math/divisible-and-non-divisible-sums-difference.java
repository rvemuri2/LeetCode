class Solution {
    public int differenceOfSums(int n, int m) {
        long totalSum = (long) n * (n + 1) / 2;
        long countDiv = n / m;
        long divisibleSum = m * countDiv * (countDiv + 1) / 2;
        return (int)(totalSum - 2 * divisibleSum);
    }
}