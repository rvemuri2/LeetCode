import java.util.*;

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int n, int k, List<Integer> path, List<List<Integer>> result) {
        // If the current combination is of size k, add it to the result
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        // Iterate from current number to n
        for (int i = start; i <= n; i++) {
            path.add(i);                        // Choose
            backtrack(i + 1, n, k, path, result); // Explore
            path.remove(path.size() - 1);       // Un-choose (backtrack)
        }
    }

    // Test code
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.combine(4, 2)); // [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
        System.out.println(sol.combine(1, 1)); // [[1]]
    }
}
