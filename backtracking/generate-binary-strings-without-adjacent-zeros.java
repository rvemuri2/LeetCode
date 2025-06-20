import java.util.*;

class Solution {
    public List<String> validStrings(int n) {
        List<String> result = new ArrayList<>();
        dfs(n, "", result);
        return result;
    }

    private void dfs(int n, String current, List<String> result) {
        if (current.length() == n) {
            result.add(current);
            return;
        }

        // If empty or last char is '1', we can add both '0' and '1'
        if (current.isEmpty() || current.charAt(current.length() - 1) == '1') {
            dfs(n, current + "0", result);
        }

        // Always allowed to add '1'
        dfs(n, current + "1", result);
    }

     public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("n = 1: " + sol.validStrings(1));
    }
}