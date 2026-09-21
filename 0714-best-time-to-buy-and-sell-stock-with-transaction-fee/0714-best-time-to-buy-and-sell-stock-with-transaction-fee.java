class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;

        // dp[day][buy][transactionsRemaining]
        int[][] dp = new int[n + 1][2];

        for (int i = n - 1; i >= 0; i--) {

            for (int buy = 0; buy <= 1; buy++) {

                    if (buy == 1) {
                        // Buy OR skip
                        dp[i][buy] = Math.max(
                            -prices[i] + dp[i + 1][0],
                            dp[i + 1][1]
                        );

                    } else {
                        // Sell OR skip
                        dp[i][buy] = Math.max(
                            prices[i] + dp[i + 1][1] - fee,
                            dp[i + 1][0]
                        );
                    }
            }
        }

        return dp[0][1];
    }
}