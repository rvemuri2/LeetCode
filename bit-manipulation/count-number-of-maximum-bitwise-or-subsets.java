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

    // ===== Tests in main =====
    public static void main(String[] args) {
        int passed = 0, total = 0;

        total++; passed += test(new int[]{3, 1}, 2, "Example 1");
        total++; passed += test(new int[]{2, 2, 2}, 7, "Example 2");
        total++; passed += test(new int[]{3, 2, 1, 5}, 6, "Example 3");

        // Single element
        total++; passed += test(new int[]{42}, 1, "Single element");
    }

    private static int test(int[] nums, int expected, String name) {
        int got = countMaxOrSubsets(nums);
        boolean ok = got == expected;
        System.out.printf("%-25s -> expected=%d, got=%d %s%n",
                name, expected, got, ok ? "[OK]" : "[FAIL]");
        return ok ? 1 : 0;
    }
}