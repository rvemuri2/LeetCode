class Solution {
    public String answerString(String word, int numFriends) {
        int n = word.length();
        int k = numFriends;

        // Special case: when k == 1, the only valid split is the entire word.
        if (k == 1) {
            return word;
        }

        // Otherwise, any piece can have length ≤ M = n - k + 1.
        int M = n - k + 1;
        int bestStart = 0;

        // Compare each candidate substring starting at i against current best
        for (int i = 1; i < n; i++) {
            if (compareCandidate(word, i, bestStart, M) > 0) {
                bestStart = i;
            }
        }

        // Return substring of length up to M
        int end = Math.min(n, bestStart + M);
        return word.substring(bestStart, end);
    }

    /**
     * Compare two candidate substrings lexicographically:
     *   A = word[i .. i+M-1] (or up to end)
     *   B = word[j .. j+M-1] (or up to end)
     * Returns >0 if A > B, <0 if A < B, else 0.
     */
    private int compareCandidate(String word, int i, int j, int M) {
        int n = word.length();
        int endA = Math.min(n, i + M);
        int endB = Math.min(n, j + M);

        int pA = i, pB = j;
        while (pA < endA && pB < endB) {
            char cA = word.charAt(pA++);
            char cB = word.charAt(pB++);
            if (cA != cB) {
                return cA - cB;
            }
        }
        // If one is a strict prefix of the other, the longer is lex-larger
        int lenA = endA - i, lenB = endB - j;
        return lenA - lenB;
    }

    // Optional main for testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.answerString("dbca", 2)); // "dbc"
        System.out.println(sol.answerString("gggg", 4)); // "g"
        // Special case k=1:
        System.out.println(sol.answerString("gh", 1));
    }
}