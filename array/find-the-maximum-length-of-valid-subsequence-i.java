import java.util.*;

class Solution {
    /**
     * Returns the number of words in the shortest transformation sequence from beginWord to endWord.
     * Uses Breadth-First Search (BFS) to explore all possible one-letter transformations level by level.
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int level = 1; // start with beginWord

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();

                for (int j = 0; j < currentWord.length(); j++) {
                    char[] chars = currentWord.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[j] = c;
                        String nextWord = new String(chars);

                        if (nextWord.equals(endWord)) {
                            return level + 1;
                        }

                        if (wordSet.contains(nextWord) && !visited.contains(nextWord)) {
                            visited.add(nextWord);
                            queue.offer(nextWord);
                        }
                    }
                }
            }
            level++;
        }

        return 0; // endWord not reachable
    }

    /**
     * Returns the length of the longest subarray from nums that is either:
     * - All same parity (even or odd), or
     * - Alternating parity, starting with even or odd
     */
    public int maximumLength(int[] nums) {
        int cntOdd = 0, cntEven = 0;
        for (int x : nums) {
            if ((x & 1) == 0) cntEven++;
            else               cntOdd++;
        }

        // 1) all even or all odd
        int bestConst = Math.max(cntOdd, cntEven);

        // 2) alternating parity (two variants)
        int altOddStart = 0, altEvenStart = 0;

        // Try alternating starting with odd
        int expect = 1;
        for (int x : nums) {
            if ((x & 1) == expect) {
                altOddStart++;
                expect ^= 1; // flip expected parity
            }
        }

        // Try alternating starting with even
        expect = 0;
        for (int x : nums) {
            if ((x & 1) == expect) {
                altEvenStart++;
                expect ^= 1;
            }
        }

        int bestAlt = Math.max(altOddStart, altEvenStart);
        return Math.max(bestConst, bestAlt);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test ladderLength
        List<String> wordList1 = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println("Test Case 1 (ladderLength): " + sol.ladderLength("hit", "cog", wordList1)); // Output: 5

        List<String> wordList2 = Arrays.asList("hot", "dot", "dog", "lot", "log");
    }
}
