import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] input1 = {{1,2}, {2,1}, {3,4}, {5,6}};
        int[][] input2 = {{1,2}, {1,2}, {1,1}, {1,2}, {2,2}};

        System.out.println(sol.numEquivDominoPairs(input1)); // Output: 1
        System.out.println(sol.numEquivDominoPairs(input2)); // Output: 3
    }

    public int numEquivDominoPairs(int[][] dominoes) {
        Map<String, Integer> map = new HashMap<>();
        int count = 0;

        for (int[] d : dominoes) {
            // Normalize the domino so that [a,b] and [b,a] are treated the same
            int a = Math.min(d[0], d[1]);
            int b = Math.max(d[0], d[1]);
            String key = a + ":" + b;

            // Count how many times we've seen this normalized domino before
            int freq = map.getOrDefault(key, 0);
            count += freq;

            // Add this domino to the map
            map.put(key, freq + 1);
        }

        return count;
    }
}
