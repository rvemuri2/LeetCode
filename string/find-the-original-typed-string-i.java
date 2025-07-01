class Solution {
    public int possibleStringCount(String word) {
        int n = word.length();
        int count = 1; // The original string itself is always a valid possibility

        int i = 0;
        while (i < n) {
            char c = word.charAt(i);
            int j = i;

            // Find length of the current run of same characters starting at index i
            while (j < n && word.charAt(j) == c) {
                j++;
            }

            int runLength = j - i;

            // If there are at least 2 consecutive same characters,
            // we can delete one occurrence from this run to simulate fixing a long press
            if (runLength >= 2) {
                count++;
            }

            // Move i to the start of the next run
            i = j;
        }

        return count;
    }

    /** Test examples for validation */
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        String word1 = "abbcccc";
        System.out.println("Test 1: " + sol.possibleStringCount(word1)); // Expected: 5

        // Example 2
        String word2 = "abcd";
        System.out.println("Test 2: " + sol.possibleStringCount(word2)); // Expected: 1

        // Example 3
        String word3 = "aaaa";
        System.out.println("Test 3: " + sol.possibleStringCount(word3)); // Expected: 4

        // Additional Test 4: multiple single character runs
        String word4 = "abcabcabc";
        System.out.println("Test 4: " + sol.possibleStringCount(word4)); // Expected: 1

        // Additional Test 5: multiple runs with different lengths
        String word5 = "aabbbcc";
        System.out.println("Test 5: " + sol.possibleStringCount(word5)); // Expected: 4
        // Explanation:
        // Runs: 'aa'(+1), 'bbb'( +1), 'cc'( +1) + original = 4

        // Additional Test 6: long single run
        String word6 = "zzzzzz";
        System.out.println("Test 6: " + sol.possibleStringCount(word6)); // Expected: 2
        // Only one run, but can delete one character to make a new possibility

        // Additional Test 7: alternating letters
        String word7 = "ababababa";
        System.out.println("Test 7: " + sol.possibleStringCount(word7)); // Expected: 1
    }
}