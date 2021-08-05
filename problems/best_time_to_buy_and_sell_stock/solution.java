class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];
            max = Math.max(max, price - minPrice);
            minPrice = Math.min(minPrice, price);
        }    
        return max;
    }
}