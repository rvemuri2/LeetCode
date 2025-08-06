class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;

        int[] secretCount = new int[10]; // For digits 0-9
        int[] guessCount = new int[10];

        // First pass: count bulls and track unmatched digits
        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s == g) {
                bulls++;
            } else {
                secretCount[s - '0']++;
                guessCount[g - '0']++;
            }
        }

        // Second pass: count cows (matching unmatched digits)
        for (int i = 0; i < 10; i++) {
            cows += Math.min(secretCount[i], guessCount[i]);
        }

        return bulls + "A" + cows + "B";
    }

    // Test cases
    public static void main(String[] args) {
        Solution sol = new Solution();

        String secret1 = "1807", guess1 = "7810";
        System.out.println("Test 1 Output: " + sol.getHint(secret1, guess1)); // 1A3B

        String secret2 = "1123", guess2 = "0111";
        System.out.println("Test 2 Output: " + sol.getHint(secret2, guess2)); // 1A1B

        String secret3 = "1", guess3 = "0";
        System.out.println("Test 3 Output: " + sol.getHint(secret3, guess3)); // 0A0B

        String secret4 = "1", guess4 = "1";
        System.out.println("Test 4 Output: " + sol.getHint(secret4, guess4));
    }
}