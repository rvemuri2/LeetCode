import java.util.*;

class Solution {
    // Minimum operations to make XOR of array equal to k
    public int minOperations(int[] nums, int k) {
        int x = 0;
        for (int v : nums) x ^= v;          // XOR of all elements
        return Integer.bitCount(x ^ k);     // number of differing bits
    }
}

public class Main {
}