import java.util.Arrays;

public class Solution {
    /**
     * Counts the number of prime numbers less than a given integer n.
     * Uses the Sieve of Eratosthenes algorithm for efficient computation.
     */
    public int countPrimes(int n) {
        if (n <= 2) return 0; // No primes less than 2

        // Boolean array to mark whether numbers are prime
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true); // Assume all numbers are prime initially
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
        }

        return count;
    }
}