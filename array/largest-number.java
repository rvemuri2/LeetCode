import java.util.*;

class Solution {
    public String largestNumber(int[] nums) {
        // Convert all numbers to strings so we can concatenate and compare
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) arr[i] = String.valueOf(nums[i]);

        // Sort by custom order: for a, b — put b before a if (b+a) > (a+b)
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        // If the largest element is "0", the entire number is 0
        if (arr[0].equals("0")) return "0";

        // Build the result
        StringBuilder sb = new StringBuilder();
        for (String s : arr) sb.append(s);
        return sb.toString();
    }

    // Simple tests
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.largestNumber(new int[]{10, 2}));                 // "210"
        System.out.println(sol.largestNumber(new int[]{3, 30, 34, 5, 9}));       // "9534330"
        System.out.println(sol.largestNumber(new int[]{0, 0}));                  // "0"
        System.out.println(sol.largestNumber(new int[]{20, 1}));                 // "201"
    }
}