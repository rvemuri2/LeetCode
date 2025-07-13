import java.util.*;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        // Count elements in nums1
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Check matches with nums2
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                result.add(num);
                map.put(num, map.get(num) - 1);
            }
        }

        // Convert list to array
        int[] intersection = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            intersection[i] = result.get(i);
        }

        return intersection;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(Arrays.toString(sol.intersect(new int[]{1,2,2,1}, new int[]{2,2})));
        // Output: [2, 2]

        System.out.println(Arrays.toString(sol.intersect(new int[]{4,9,5}, new int[]{9,4,9,8,4})));
        // Output: [4, 9] or [9, 4]

        System.out.println(Arrays.toString(sol.intersect(new int[]{1,2,2,3,3,3}, new int[]{2,3,3,4})));
        // Output: [2, 3, 3]

        System.out.println(Arrays.toString(sol.intersect(new int[]{1,1,1,1}, new int[]{1,1})));
        // Output: [1, 1]

        System.out.println(Arrays.toString(sol.intersect(new int[]{}, new int[]{1,2})));
        // Output: []

        System.out.println(Arrays.toString(sol.intersect(new int[]{1,2}, new int[]{})));
        // Output: []

        System.out.println(Arrays.toString(sol.intersect(new int[]{1,2,3}, new int[]{4,5,6})));
    }
}