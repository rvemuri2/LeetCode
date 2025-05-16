import java.util.*;

public class LongestValidSubsequence {

    // Helper method to calculate Hamming distance
    private static int hammingDistance(String a, String b) {
        int dist = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                dist++;
            }
        }
        return dist;
    }

    // DFS with memoization to get the longest valid path starting from node i
    private static List<Integer> dfs(int i, List<List<Integer>> graph, Map<Integer, List<Integer>> memo) {
        if (memo.containsKey(i)) {
            return memo.get(i);
        }

        List<Integer> bestPath = new ArrayList<>();
        bestPath.add(i); // Include current node

        for (int neighbor : graph.get(i)) {
            List<Integer> pathFromNeighbor = dfs(neighbor, graph, memo);
            if (pathFromNeighbor.size() + 1 > bestPath.size()) {
                bestPath = new ArrayList<>();
                bestPath.add(i);
                bestPath.addAll(pathFromNeighbor);
            }
        }

        memo.put(i, bestPath);
        return bestPath;
    }

    public static List<String> longestValidSubsequence(String[] words, int[] groups) {
        int n = words.length;

        // Build the graph: edges[i] will contain a list of indices j that can follow i
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) edges.add(new ArrayList<>());

        for (int i = 0; i < n; i++) {
            String w1 = words[i];
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                String w2 = words[j];
                if (groups[i] != groups[j] && w1.length() == w2.length()
                        && hammingDistance(w1, w2) == 1) {
                    edges.get(i).add(j);
                }
            }
        }

        // Memoization map
        Map<Integer, List<Integer>> memo = new HashMap<>();
        List<Integer> longestPath = new ArrayList<>();

        // Try DFS from each node
        for (int i = 0; i < n; i++) {
            List<Integer> path = dfs(i, edges, memo);
            if (path.size() > longestPath.size()) {
                longestPath = path;
            }
        }

        // Convert index path to word path
        List<String> result = new ArrayList<>();
        for (int index : longestPath) {
            result.add(words[index]);
        }
        return result;
    }

    public static void main(String[] args) {
        String[] words1 = {"bab", "dab", "cab"};
        int[] groups1 = {1, 2, 2};
        System.out.println(longestValidSubsequence(words1, groups1));
        // Output: ["bab", "dab"] or ["bab", "cab"]

        String[] words2 = {"a", "b", "c", "d"};
        int[] groups2 = {1, 2, 3, 4};
        System.out.println(longestValidSubsequence(words2, groups2));
        // Output: ["a", "b", "c", "d"]
    }
}