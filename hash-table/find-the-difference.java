class Solution {
    public char findTheDifference(String s, String t) {
        char res = 0;
        for (char c : s.toCharArray()) {
            res ^= c;
        }
        for (char c : t.toCharArray()) {
            res ^= c;
        }
        return res;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.findTheDifference("abcd", "abcde")); // Output: e
        System.out.println(sol.findTheDifference("", "y"));         // Output: y
        System.out.println(sol.findTheDifference("a", "aa"));       // Output: a
        System.out.println(sol.findTheDifference("ae", "aea"));     // Output: a
    }
}