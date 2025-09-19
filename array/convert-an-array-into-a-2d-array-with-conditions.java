class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        // Result 2D array
        List<List<Integer>> result = new ArrayList<>();
        
        // Count frequency of each number
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : nums)
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        
        int maxFreq = Collections.max(freq.values());
        
        for (int row = 0; row < maxFreq; row++) {
            List<Integer> currentRow = new ArrayList<>();
            
            for (int key : freq.keySet()) {
                if (freq.get(key) > 0) {
                    currentRow.add(key);
                    freq.put(key, freq.get(key) - 1);
                }
            }
            result.add(currentRow);
        }
        return result;
    }
}