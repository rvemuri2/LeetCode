class Solution {
    public int maxDistance(String s, int k) {
        int n = s.length();
        int max = 0;

        // net (x, y) from movements
        int x = 0, y = 0;

        // Track positions at each step to allow backtracking k steps
        int[] dx = new int[n];
        int[] dy = new int[n];

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'N') y++;
            else if (c == 'S') y--;
            else if (c == 'E') x++;
            else if (c == 'W') x--;

            dx[i] = x;
            dy[i] = y;
        }

        // Initialize answer with final position
        max = Math.abs(x) + Math.abs(y);

        // Try converting up to k previous moves to a better direction at each step
        for (int i = 0; i < n; i++) {
            for (char change : new char[] {'N', 'S', 'E', 'W'}) {
                // Apply up to k changes
                int nx = dx[i], ny = dy[i];

                // reverse the effect of s[i] and apply change
                char original = s.charAt(i);

                if (original == 'N') ny--;
                if (original == 'S') ny++;
                if (original == 'E') nx--;
                if (original == 'W') nx++;

                if (change == 'N') ny++;
                if (change == 'S') ny--;
                if (change == 'E') nx++;
                if (change == 'W') nx--;

                // Calculate max distance after change
                max = Math.max(max, Math.abs(nx) + Math.abs(ny));
            }
        }

        return max;
    }
}