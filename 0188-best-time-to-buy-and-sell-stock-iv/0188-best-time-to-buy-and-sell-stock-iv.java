class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        // dp[day][buy][transactionsRemaining]
        int[][][] dp = new int[n + 1][2][k+1];

        for (int i = n - 1; i >= 0; i--) {

            for (int buy = 0; buy <= 1; buy++) {

                for (int cap = 1; cap <=k; cap++) {

                    if (buy == 1) {
                        // Buy OR skip
                        dp[i][buy][cap] = Math.max(
                            -prices[i] + dp[i + 1][0][cap],
                            dp[i + 1][1][cap]
                        );

                    } else {
                        // Sell OR skip
                        dp[i][buy][cap] = Math.max(
                            prices[i] + dp[i + 1][1][cap - 1],
                            dp[i + 1][0][cap]
                        );
                    }
                }
            }
        }

        return dp[0][1][k];
    }
}