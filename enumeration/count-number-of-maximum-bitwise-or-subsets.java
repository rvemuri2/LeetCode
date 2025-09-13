class Solution {
    // ===== Solution =====
    public static int countMaxOrSubsets(int[] nums) {
        int target = 0;
        for (int x : nums) target |= x;

        // DFS over subsets counting those whose OR == target
        return dfsCount(nums, 0, 0, target);
    }

    private static int dfsCount(int[] nums, int i, int curOr, int target) {
        if (i == nums.length) {
            return curOr == target ? 1 : 0;
        }
        // choose nums[i]
        int take = dfsCount(nums, i + 1, curOr | nums[i], target);
        // skip nums[i]
        int skip = dfsCount(nums, i + 1, curOr, target);
        return take + skip;
    }

    private static int test(int[] nums, int expected, String name) {
        boolean ok = got == expected;
        return ok ? 1 : 0;
    }
}