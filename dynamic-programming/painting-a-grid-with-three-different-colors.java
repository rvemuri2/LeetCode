import java.util.*;

public class Solution {
    static final int MOD = 1_000_000_007;
    static final int COLORS = 3;
    private void generateStates(int m, int pos, int[] curr, List<int[]> states) {
        if (pos == m) {
            states.add(Arrays.copyOf(curr, m));
            return;
        }

        for (int color = 0; color < COLORS; color++) {
            if (pos > 0 && curr[pos - 1] == color) continue;
            curr[pos] = color;
            generateStates(m, pos + 1, curr, states);
        }
    }

    public int colorTheGrid(int m, int n) {
        List<int[]> states = new ArrayList<>();
        generateStates(m, 0, new int[m], states);
        int S = states.size();

        Map<String, Integer> stateIndex = new HashMap<>();
        for (int i = 0; i < S; i++) {
            stateIndex.put(Arrays.toString(states.get(i)), i);
        }

        List<Integer>[] transitions = new ArrayList[S];
        for (int i = 0; i < S; i++) {
            transitions[i] = new ArrayList<>();
            for (int j = 0; j < S; j++) {
                boolean compatible = true;
                for (int k = 0; k < m; k++) {
                    if (states.get(i)[k] == states.get(j)[k]) {
                        compatible = false;
                        break;
                    }
                }
                if (compatible) {
                    transitions[i].add(j);
                }
            }
        }
        int[] dp = new int[S];
        Arrays.fill(dp, 1);
        for (int col = 1; col < n; col++) {
            int[] newDp = new int[S];
            for (int i = 0; i < S; i++) {
                for (int prev : transitions[i]) {
                    newDp[i] = (newDp[i] + dp[prev]) % MOD;
                }
            }
            dp = newDp;
        }
        int total = 0;
        for (int val : dp) {
            total = (total + val) % MOD;
        }
        return total;
    }
}
