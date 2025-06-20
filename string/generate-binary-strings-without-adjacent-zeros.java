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

        if (current.isEmpty() || current.charAt(current.length() - 1) == '1') {
            dfs(n, current + "0", result);
        }

        dfs(n, current + "1", result);
    }
}