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
}