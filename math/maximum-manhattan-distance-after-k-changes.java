import java.util.*;

class Solution {
    public int maxDistance(String s, int k) {
        int n = s.length();
        int[][] directions = {
            {0, 1},  // N
            {0, -1}, // S
            {1, 0},  // E
            {-1, 0}  // W
        };
        char[] dirChars = {'N', 'S', 'E', 'W'};
        Map<Character, int[]> dirMap = Map.of(
            'N', directions[0],
            'S', directions[1],
            'E', directions[2],
            'W', directions[3]
        );

        // State: {x, y, index in string, changes remaining}
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(new int[]{0, 0, 0, k});
        visited.add("0,0,0," + k);
        int maxDist = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0], y = curr[1], i = curr[2], changes = curr[3];
            maxDist = Math.max(maxDist, Math.abs(x) + Math.abs(y));
            if (i == n) continue;

            // Case 1: Use current character as-is
            int[] move = dirMap.get(s.charAt(i));
            int nx = x + move[0];
            int ny = y + move[1];
            String key = nx + "," + ny + "," + (i + 1) + "," + changes;
            if (!visited.contains(key)) {
                visited.add(key);
                queue.add(new int[]{nx, ny, i + 1, changes});
            }

            // Case 2: Change current character (if allowed)
            if (changes > 0) {
                for (char ch : dirChars) {
                    if (ch == s.charAt(i)) continue; // Skip same direction
                    int[] mv = dirMap.get(ch);
                    int cx = x + mv[0];
                    int cy = y + mv[1];
                    String ckey = cx + "," + cy + "," + (i + 1) + "," + (changes - 1);
                    if (!visited.contains(ckey)) {
                        visited.add(ckey);
                        queue.add(new int[]{cx, cy, i + 1, changes - 1});
                    }
                }
            }
        }

        return maxDist;
    }

    // Test cases
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maxDistance("NWSE", 1)); // Expected: 3
        System.out.println(sol.maxDistance("NSWWEW", 3)); // Expected: 6
        System.out.println(sol.maxDistance("NNNN", 0)); // Expected: 4
        System.out.println(sol.maxDistance("S", 1)); // Expected: 1
    }
}