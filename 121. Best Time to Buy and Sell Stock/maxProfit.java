class Solution {
    public int maxProfit(int[] prices) {
        //Brute force
        /*int max = 0;
        for(int i = 0; i < prices.length; i++){
            for(int j = i+1; j < prices.length; j++){
                int profit = prices[j] - prices[i];
                if(profit > max){
                    max = profit;
                }
            }
        }
        return max;*/
        
        //one pass
        //store the minprice and maximum profit
        int min = Integer.MAX_VALUE;
        int maxprofit = 0;
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < min){
                min = prices[i];
            }
            else if(prices[i] - min > maxprofit){
                maxprofit = prices[i] - min;
            }         
            
        }
        return maxprofit;
    }
}
