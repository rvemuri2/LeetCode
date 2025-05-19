public class Solution {
    public String triangleType(int[] nums) {
        int a = nums[0], b = nums[1], c = nums[2];

        // Check for triangle inequality
        if (a + b <= c || a + c <= b || b + c <= a) {
            return "none";
        }

        // Check triangle type
        if (a == b && b == c) {
            return "equilateral";
        } else if (a == b || b == c || a == c) {
            return "isosceles";
        } else {
            return "scalene";
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.triangleType(new int[]{3, 3, 3}));
        System.out.println(sol.triangleType(new int[]{3, 4, 5}));
    }
}
