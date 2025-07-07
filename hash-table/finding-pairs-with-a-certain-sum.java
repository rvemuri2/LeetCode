class FindSumPairs {
    private int[] nums1, nums2;
    private Map<Integer, Integer> freq2;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.freq2 = new HashMap<>();
        for (int x : nums2) {
            freq2.put(x, freq2.getOrDefault(x, 0) + 1);
        }
    }
    public void add(int index, int val) {
        int old = nums2[index];
        int updated = old + val;

        freq2.put(old, freq2.get(old) - 1);
        if (freq2.get(old) == 0) {
            freq2.remove(old);
        }
        nums2[index] = updated;
        freq2.put(updated, freq2.getOrDefault(updated, 0) + 1);
    }
    public int count(int tot) {
        int answer = 0;
        for (int x : nums1) {
            int need = tot - x;
            answer += freq2.getOrDefault(need, 0);
        }
        return answer;
    }
}