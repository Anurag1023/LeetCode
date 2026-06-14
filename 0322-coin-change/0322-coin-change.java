class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];

        for(int[] arr: dp){
            Arrays.fill(arr,-1);
        }

        for(int t=0; t<=amount; t++){

            if(t%coins[0]==0) dp[0][t] = t/coins[0];
            else dp[0][t] = (int)1e9;

        }

        for(int ind=1; ind<n;ind++){
            for(int target=0; target<=amount; target++){
                if(dp[ind][target]!=-1) return dp[ind][target];
                int take = (int)1e9;
                if(target>=coins[ind]) take = 1 + dp[ind][target-coins[ind]];
                int notTake = dp[ind-1][target];
                dp[ind][target] = Math.min(take, notTake);
            }
        }
        
        int ans = dp[n-1][amount];
        return ans==(int)1e9?-1:ans;
    }
}