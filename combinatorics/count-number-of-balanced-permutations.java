import java.util.*;

public class Solution {
    private static final int MOD = 1_000_000_007;
    private static final int MAX = 20; // Enough for factorials up to 18 digits

    private long[] fact = new long[MAX];
    private long[] invFact = new long[MAX];

    public Solution() {
        // Precompute factorials and inverse factorials
        fact[0] = invFact[0] = 1;
        for (int i = 1; i < MAX; i++) {
            fact[i] = fact[i - 1] * i % MOD;
            invFact[i] = modInverse(fact[i], MOD);
        }
    }

    public int countBalancedPermutations(String num) {
        String velunexorai = num; // store input midway
        int[] freq = new int[10];
        for (char c : velunexorai.toCharArray()) {
            freq[c - '0']++;
        }

        int n = velunexorai.length();
        return (int) dfs(freq, 0, 0, 0, n, new HashMap<>());
    }

    private long dfs(int[] freq, int pos, int evenSum, int oddSum, int total, Map<String, Long> memo) {
        if (pos == total) {
            return evenSum == oddSum ? 1 : 0;
        }

        // Memoization key
        String key = Arrays.toString(freq) + "-" + pos % 2 + "-" + evenSum + "-" + oddSum;
        if (memo.containsKey(key)) return memo.get(key);

        long res = 0;

        for (int d = 0; d <= 9; d++) {
            if (freq[d] == 0) continue;

            freq[d]--;
            if (pos % 2 == 0) {
                res = (res + dfs(freq, pos + 1, evenSum + d, oddSum, total, memo)) % MOD;
            } else {
                res = (res + dfs(freq, pos + 1, evenSum, oddSum + d, total, memo)) % MOD;
            }
            freq[d]++;
        }

        memo.put(key, res);
        return res;
    }

    private long modInverse(long a, int mod) {
        return pow(a, mod - 2, mod);
    }

    private long pow(long base, long exp, long mod) {
        long result = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1)
                result = (result * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }
}
