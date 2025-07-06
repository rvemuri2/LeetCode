import java.util.*;

class Solution {
    public int possibleStringCount(String word) {
        int n = word.length();
        int total = 1;
        
        int i = 0;
        while (i < n) {
            char c = word.charAt(i);
            int j = i;
            while (j < n && word.charAt(j) == c) {
                j++;
            }
            int runLen = j - i;
            if (runLen >= 2) {
                total += (runLen - 1);
            }
            i = j;
        }
        
        return total;
    }
}
