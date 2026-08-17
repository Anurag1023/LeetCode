class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];

        for(int[] a:dp) Arrays.fill(a,Integer.MAX_VALUE);

        int ans = helper(n - 1, amount, coins,dp);

        return ans == Integer.MAX_VALUE - 1 ? -1 : ans;
    }

    private int helper(int i, int amount, int[] coins,int[][] dp) {

        if (amount == 0) {
            return 0;
        }

        if (i < 0) {
            return Integer.MAX_VALUE - 1;
        }

        if(dp[i][amount]!=Integer.MAX_VALUE) return dp[i][amount];

        int not = helper(i - 1, amount, coins,dp);

        int take = Integer.MAX_VALUE - 1;

        if (amount >= coins[i]) {
            take = 1 + helper(i, amount - coins[i], coins,dp);
        }

        return dp[i][amount] = Math.min(take, not);
    }
}