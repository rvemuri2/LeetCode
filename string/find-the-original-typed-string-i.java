class Solution {
    public int possibleStringCount(String word) {
        int n = word.length();
        int count = 1; // The original string itself

        boolean deleted = false;

        int i = 0;
        while (i < n) {
            char c = word.charAt(i);
            int j = i;

            // Find run length
            while (j < n && word.charAt(j) == c) {
                j++;
            }

            int runLength = j - i;

            // Only ONE deletion allowed in total
            if (!deleted && runLength >= 2) {
                count++;
                deleted = true;
            }

            i = j;
        }

        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String word1 = "abbcccc";
        System.out.println("Test 1: " + sol.possibleStringCount(word1)); // Expected: 5

        String word2 = "abcd";
        System.out.println("Test 2: " + sol.possibleStringCount(word2)); // Expected: 1

        String word3 = "aaaa";
        System.out.println("Test 3: " + sol.possibleStringCount(word3)); // Expected: 2

        String word4 = "abcabcabc";
        System.out.println("Test 4: " + sol.possibleStringCount(word4)); // Expected: 1

        String word5 = "aabbbcc";
        System.out.println("Test 5: " + sol.possibleStringCount(word5)); // Expected: 2
    }
}
