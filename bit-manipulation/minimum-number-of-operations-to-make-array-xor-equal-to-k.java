class Solution {
    public int minOperations(int[] nums, int k) {
        int x = 0;
        for (int v : nums)
            x ^= v;
        return Integer.bitCount(x ^ k);     
    }
}