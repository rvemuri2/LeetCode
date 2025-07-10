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
    public static void main(String[] args) {}
}
