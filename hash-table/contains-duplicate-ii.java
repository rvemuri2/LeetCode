import java.util.HashMap;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>(); // value -> last seen index

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int prevIndex = map.get(nums[i]);
                if (i - prevIndex <= k) {
                    return true;
                }
            }
            map.put(nums[i], i); // update the last seen index
        }

        return false;
    }

    // Example test cases
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));    // true
        System.out.println(sol.containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));    // true
    }
}