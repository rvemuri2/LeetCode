import java.util.HashMap;

class Solution {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int maxLen = 0;

        // Count frequencies of each number
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // For each key, check if (key + 1) exists to form harmonious subsequence
        for (int key : freq.keySet()) {
            if (freq.containsKey(key + 1)) {
                maxLen = Math.max(maxLen, freq.get(key) + freq.get(key + 1));
            }
        }

        return maxLen;
    }

    /** Quick test */
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.findLHS(new int[]{1,3,2,2,5,2,3,7}));
    }
}