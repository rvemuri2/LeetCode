class Solution {
    public static int countMaxOrSubsets(int[] nums) {
        int target = 0;
        for (int x : nums) {
            target |= x;
        }

        return dfsCount(nums, 0, 0, target);
    }

    private static int dfsCount(int[] nums, int i, int curOr, int target) {
        if (i == nums.length) {
            return curOr == target ? 1 : 0;
        }
        int take = dfsCount(nums, i + 1, curOr | nums[i], target);
        int skip = dfsCount(nums, i + 1, curOr, target);
        return take + skip;
    }
}