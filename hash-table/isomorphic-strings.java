import java.util.*;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        // Maps for both directions
        Map<Character, Character> mapST = new HashMap<>();
        Map<Character, Character> mapTS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            // Check if mapping exists from s -> t
            if (mapST.containsKey(c1)) {
                if (mapST.get(c1) != c2) return false;
            } else {
                mapST.put(c1, c2);
            }

            // Check reverse mapping from t -> s to ensure bijection
            if (mapTS.containsKey(c2)) {
                if (mapTS.get(c2) != c1) return false;
            } else {
                mapTS.put(c2, c1);
            }
        }

        return true;
    }

    // Quick tests
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.isIsomorphic("egg", "add")); // true
        System.out.println(sol.isIsomorphic("foo", "bar")); // false
    }
}
