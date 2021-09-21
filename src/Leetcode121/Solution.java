package Leetcode121;

class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];
        for (int a : prices
        ) {
            if (a <= minPrice) {
                minPrice = a;
                continue;
            }
            maxProfit = Math.max(maxProfit, a - minPrice);
        }
        return maxProfit;
    }
}