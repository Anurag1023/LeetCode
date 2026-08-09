class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int max = 0;
        int diff = 0;
        for(int i=n-1;i>=0;i--){
            if(prices[i]>max){
                max = prices[i];
            }
            diff = Math.max(diff, max-prices[i]);
        }
        return diff;
    }
}