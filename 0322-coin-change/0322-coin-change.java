class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[amount+1][coins.length];

        for(int[] d: dp){
            Arrays.fill(d,-1);
        }

        int cnt = helper(coins,amount,coins.length-1,dp);
        return dp[amount][coins.length-1]>=(int)1e9?-1:dp[amount][coins.length-1];
    }

    private int helper(int[] coins, int amount,int ind,int[][] dp){
        if(ind==0){
            if(amount%coins[ind]==0){
                return dp[amount][ind]= amount/coins[ind];
            }else return dp[amount][ind] = (int)1e9;
        }

        if(dp[amount][ind]!=-1) return dp[amount][ind];

        int take = (int)1e9;
        if(coins[ind]<=amount) take = 1 + helper(coins,amount-coins[ind],ind,dp);

        int notTake = helper(coins,amount,ind-1,dp);
        return dp[amount][ind]= Math.min(take, notTake);
    }
 }