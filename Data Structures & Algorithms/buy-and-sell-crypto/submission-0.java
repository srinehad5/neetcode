class Solution {
    public int maxProfit(int[] prices) {
        
        int n = prices.length;
        int buy = prices[0];
        int profit = 0;
        for(int i = 1; i < n; i++){
            if(prices[i] > buy);
                profit = Math.max(profit, prices[i]-buy);
            buy = Math.min(buy, prices[i]);
        }

        return profit;
    }
}
