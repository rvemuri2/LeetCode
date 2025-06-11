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

        // Sieve process: Mark multiples of each prime as not prime
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                // Start marking from i*i, not i*2 (already handled by smaller primes)
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Count how many numbers are still marked as prime
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
        }

        return count;
    }

    // Main method for running sample tests
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test case 1: n = 10 → primes: 2, 3, 5, 7 → count = 4
        System.out.println("countPrimes(10) = " + sol.countPrimes(10)); // Expected: 4

        // Test case 2: n = 0 → no primes
        System.out.println("countPrimes(0) = " + sol.countPrimes(0)); // Expected: 0

        // Test case 3: n = 1 → no primes
        System.out.println("countPrimes(1) = " + sol.countPrimes(1)); // Expected: 0

        // Test case 4: n = 100 → test with larger input
        System.out.println("countPrimes(100) = " + sol.countPrimes(100)); // Expected: 25

        // Test case 5: Edge case with a large number
    }
}