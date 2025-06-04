class Solution {
    public String answerString(String word, int numFriends) {
        int n = word.length();
        int k = numFriends;

        // Special case: when k == 1, the only valid split is the entire word.
        if (k == 1) {
            return word;
        }

        int M = n - k + 1;
        int bestStart = 0;

        for (int i = 1; i < n; i++) {
            if (compareCandidate(word, i, bestStart, M) > 0) {
                bestStart = i;
            }
        }
        int end = Math.min(n, bestStart + M);
        return word.substring(bestStart, end);
    }
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
        int lenA = endA - i, lenB = endB - j;
        return lenA - lenB;
    }
}