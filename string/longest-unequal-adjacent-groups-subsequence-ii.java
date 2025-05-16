import java.util.*;

public class Solution {

    private static int hammingDistance(String a, String b) {
        int dist = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                dist++;
            }
        }
        return dist;
    }

    // DFS with visited set for cycle protection
    private static List<Integer> dfs(int i, List<List<Integer>> graph, Map<Integer, List<Integer>> memo, Set<Integer> visiting) {
        if (memo.containsKey(i)) return memo.get(i);
        if (visiting.contains(i)) return new ArrayList<>(); // prevent infinite loop

        visiting.add(i);
        List<Integer> bestPath = new ArrayList<>();
        bestPath.add(i);

        for (int neighbor : graph.get(i)) {
            List<Integer> neighborPath = dfs(neighbor, graph, memo, visiting);
            if (neighborPath.size() + 1 > bestPath.size()) {
                bestPath = new ArrayList<>();
                bestPath.add(i);
                bestPath.addAll(neighborPath);
            }
        }

        visiting.remove(i);
        memo.put(i, bestPath);
        return bestPath;
    }

    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < n; i++) {
            String w1 = words[i];
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                String w2 = words[j];
                if (groups[i] != groups[j] && w1.length() == w2.length() && hammingDistance(w1, w2) == 1) {
                    graph.get(i).add(j);
                }
            }
        }

        Map<Integer, List<Integer>> memo = new HashMap<>();
        List<Integer> longestPath = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Set<Integer> visiting = new HashSet<>();
            List<Integer> path = dfs(i, graph, memo, visiting);
            if (path.size() > longestPath.size()) {
                longestPath = path;
            }
        }

        List<String> result = new ArrayList<>();
        for (int index : longestPath) {
            result.add(words[index]);
        }
        return result;
    }
}
