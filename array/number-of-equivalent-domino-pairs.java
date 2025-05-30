import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] input1 = {{1,2}, {2,1}, {3,4}, {5,6}};
        int[][] input2 = {{1,2}, {1,2}, {1,1}, {1,2}, {2,2}};

    }

    public int numEquivDominoPairs(int[][] dominoes) {
        Map<String, Integer> map = new HashMap<>();
        int count = 0;

        for (int[] d : dominoes) {
           
            int a = Math.min(d[0], d[1]);
            int b = Math.max(d[0], d[1]);
            String key = a + ":" + b;

            int freq = map.getOrDefault(key, 0);
            count += freq;

            map.put(key, freq + 1);
        }

        return count;
    }
}
