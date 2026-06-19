class Solution {

    private int helper(int amount, int[] coins, int ind, int[][] dp ){
        if(amount==0) return dp[ind][amount]=1;

        if(ind==0){
            if(amount%coins[0]==0) return dp[ind][amount]=1;
            else return 0;
        }

        if(dp[ind][amount]!=-1) return dp[ind][amount];

        int notTake = helper(amount, coins, ind-1,dp);
        int take = 0;
        if(coins[ind]<=amount) take = helper(amount-coins[ind],coins,ind,dp);

        return dp[ind][amount] = take + notTake;
    }

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];

        for(int[] a: dp){
            Arrays.fill(a,-1);
        }

        return helper(amount,coins,n-1,dp);
    }
}