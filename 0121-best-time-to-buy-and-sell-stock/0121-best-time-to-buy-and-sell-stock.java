import java.lang.Math;

class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int profit = 0;
        for(int i=1; i<prices.length; i++){
            int price = prices[i];
            profit = Math.max(profit,price-min);
            min = Math.min(min,price);
        }

        return profit;
    }
}