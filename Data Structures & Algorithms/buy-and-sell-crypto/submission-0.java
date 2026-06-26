class Solution {
    public int maxProfit(int[] prices) {
        int length=prices.length, buy=Integer.MAX_VALUE, profit=0;

        for(int i=0;i<length;i++){
            if(prices[i] < buy){
                buy=prices[i];
            }
            else{
                profit=Math.max(profit, prices[i]-buy);
            }
        }

        return profit;
        
    }
}
