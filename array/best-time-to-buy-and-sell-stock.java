class Solution {
    public int maxProfit(int[] prices) {
        // Initialize minimum price to a large value
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        // Iterate through each day's price
        for (int price : prices) {
            // If current price is lower than minPrice, update minPrice
            if (price < minPrice) {
                minPrice = price;
            } else {
                // Else calculate profit and update maxProfit if it's higher
                int profit = price - minPrice;
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }

        return maxProfit;
    }

    // Test cases
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] prices1 = {7,1,5,3,6,4};
        System.out.println(sol.maxProfit(prices1)); // Output: 5

        int[] prices2 = {7,6,4,3,1};
        System.out.println(sol.maxProfit(prices2)); // Output: 0

        int[] prices3 = {1,2};
        System.out.println(sol.maxProfit(prices3)); // Output: 1

        int[] prices4 = {2,4,1};
        System.out.println(sol.maxProfit(prices4)); // Output: 2
    }
}
