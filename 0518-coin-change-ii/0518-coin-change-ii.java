class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];

        for (int t = 0; t <= amount; t++) {
            if (t % coins[0] == 0) {
                dp[0][t] = 1;
            }
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<=amount;j++){

                if(j == 0){
                    dp[i][j] = 1;
                    continue;
                }

                if(i==0){
                    if(j%coins[0]==0) dp[i][j]=1;
                    else  dp[i][j] = 0;
                }

                int notTake = dp[i-1][j];
                int take = 0;
                if(coins[i]<=j) take = dp[i][j-coins[i]];

                dp[i][j] = take + notTake;                

            }
        }

        return dp[n-1][amount];
    }
}