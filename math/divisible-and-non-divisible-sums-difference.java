class Solution {
    public int differenceOfSums(int n, int m) {
        // Sum of all integers from 1 to n
        long totalSum = (long) n * (n + 1) / 2;

        // Count of multiples of m in [1, n]
        long countDiv = n / m;

        // Sum of multiples of m
        long divisibleSum = m * countDiv * (countDiv + 1) / 2;
        return (int)(totalSum - 2 * divisibleSum);
    }
}