class Solution {
    // Reconstruct arr from its prefix-xor array pref.
    // Key idea:
    public int[] findArray(int[] pref) {
        int n = pref.length;
        int[] arr = new int[n];
        if (n == 0) {
            return arr;
        }

        arr[0] = pref[0];
        for (int i = 1; i < n; i++) {
            arr[i] = pref[i - 1] ^ pref[i];
        }
        return arr;
    }
}
