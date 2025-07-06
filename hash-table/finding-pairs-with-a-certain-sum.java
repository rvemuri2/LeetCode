import java.util.*;

class FindSumPairs {
    private int[] nums1, nums2;
    private Map<Integer, Integer> freq2;

    /**
     * Initialize with nums1 and nums2.
     * We keep nums1 as-is, and build a frequency map for nums2.
     */
    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.freq2 = new HashMap<>();
        for (int x : nums2) {
            freq2.put(x, freq2.getOrDefault(x, 0) + 1);
        }
    }
    
    /**
     * Add val to nums2[index], updating our frequency map.
     */
    public void add(int index, int val) {
        int old = nums2[index];
        int updated = old + val;
        // Decrement freq of old value
        freq2.put(old, freq2.get(old) - 1);
        // If count drops to 0, remove the key to keep the map small
        if (freq2.get(old) == 0) {
            freq2.remove(old);
        }
        // Update array and increment freq of new value
        nums2[index] = updated;
        freq2.put(updated, freq2.getOrDefault(updated, 0) + 1);
    }
    
    /**
     * Count how many pairs (i, j) satisfy nums1[i] + nums2[j] == tot.
     * We iterate over nums1 and look up the complement in freq2.
     */
    public int count(int tot) {
        int answer = 0;
        for (int x : nums1) {
            int need = tot - x;
            answer += freq2.getOrDefault(need, 0);
        }
        return answer;
    }

    // ---------- Simple test -------------
    public static void main(String[] args) {
        FindSumPairs findSumPairs = new FindSumPairs(
            new int[]{1,1,2,2,2,3},
            new int[]{1,4,5,2,5,4}
        );
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */