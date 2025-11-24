class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(nums); 
        backtrack(0, nums, path, list);
        return list;
    }

    private void backtrack(int start, int[] nums, List<Integer> path, List<List<Integer>> list) {
        list.add(new ArrayList<>(path));
        
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);

            backtrack(i + 1, nums, path, list);
            path.remove(path.size() - 1);
        }
    }
}