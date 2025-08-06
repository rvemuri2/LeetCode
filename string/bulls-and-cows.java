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
    }
}