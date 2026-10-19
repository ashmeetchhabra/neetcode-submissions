class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        Integer buy = Integer.MAX_VALUE;
        for(int i=0; i<prices.length; i++){
            if(prices[i]<buy)
                buy = prices[i];
            else{
                int profit = prices[i]-buy;
                maxProfit = Math.max(maxProfit,profit);
            }
        }
        return maxProfit;
    }
}
