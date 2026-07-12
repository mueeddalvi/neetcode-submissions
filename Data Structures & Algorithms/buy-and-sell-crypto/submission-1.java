class Solution {
    public int maxProfit(int[] prices) {
        int p = 0;
        int n = prices.length;

        if(n==1)
            return 0;
        int currMin = prices[0];
        for(int x:prices){
            if(x < currMin){
                currMin=x;
            }
            else{
                p=Math.max(p, x-currMin);
            }
        } 

        return p;
        
    }
}
