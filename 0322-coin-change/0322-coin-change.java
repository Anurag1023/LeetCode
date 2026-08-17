class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int INF = Integer.MAX_VALUE - 1;

        int[][] dp = new int[n + 1][amount + 1];

        // 0 coins needed to make amount 0
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        // Impossible initially
        for (int j = 1; j <= amount; j++) {
            dp[0][j] = INF;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {

                // Don't take coin
                int not = dp[i - 1][j];

                // Take coin
                int take = INF;

                if (coins[i - 1] <= j) {
                    take = 1 + dp[i][j - coins[i - 1]];
                }

                dp[i][j] = Math.min(take, not);
            }
        }

        return dp[n][amount] == INF ? -1 : dp[n][amount];
    }
}