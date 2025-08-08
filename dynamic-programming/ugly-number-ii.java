public class Solution {
    /**
     * Returns the nth ugly number.
     * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
     * 
     * @param n The position of the ugly number to find
     * @return The nth ugly number
     */
    public int nthUglyNumber(int n) {
        // Array to store the first n ugly numbers
        int[] ugly = new int[n];
        ugly[0] = 1; // First ugly number is always 1

        // Pointers for multiples of 2, 3, and 5 respectively
        int i2 = 0, i3 = 0, i5 = 0;

        // Initialize the next multiples of 2, 3, and 5
        int next2 = 2;
        int next3 = 3;
        int next5 = 5;

        // Generate remaining n-1 ugly numbers
        for (int i = 1; i < n; i++) {
            // Choose the smallest among the candidates
            int next = Math.min(next2, Math.min(next3, next5));
            ugly[i] = next;

            // Increment the pointer(s) whose value matched the selected ugly number
            if (next == next2) next2 = ugly[++i2] * 2;
            if (next == next3) next3 = ugly[++i3] * 3;
            if (next == next5) next5 = ugly[++i5] * 5;
        }

        // Return the last element in the ugly number list, which is the nth one
        return ugly[n - 1];
    }
}