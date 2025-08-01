class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int level = 1;

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

        return 0;
    }

    public int maximumLength(int[] nums) {
        int cntOdd = 0, cntEven = 0;
        for (int x : nums) {
            if ((x & 1) == 0) {
                cntEven++;
            }
            else {
                cntOdd++;
            }
        }

        int bestConst = Math.max(cntOdd, cntEven);

        int altOddStart = 0, altEvenStart = 0;

        int expect = 1;
        for (int x : nums) {
            if ((x & 1) == expect) {
                altOddStart++;
                expect ^= 1;
            }
        }
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
}
