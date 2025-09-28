import java.util.*;

class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s;
        String rs = new StringBuilder(s).reverse().toString();
        String t = s + "#" + rs;
        int[] lps = buildLPS(t);
        int longestPrefixPal = lps[t.length() - 1]; // length of longest palindromic prefix
        String suffix = s.substring(longestPrefixPal);
        return new StringBuilder(suffix).reverse().toString() + s;
    }

    // KMP prefix-function (LPS array)
    private int[] buildLPS(String str) {
        int n = str.length();
        int[] lps = new int[n];
        int len = 0;
        for (int i = 1; i < n; i++) {
            while (len > 0 && str.charAt(i) != str.charAt(len)) {
                len = lps[len - 1];
            }
            if (str.charAt(i) == str.charAt(len)) len++;
            lps[i] = len;
        }
        return lps;
    }
}

public class Main {
    public static void main(String[] args) {
    }
}