class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i < n + 1; i++)
            dp[i][0] = i;
        for (int i = 0; i < m + 1; i++)
            dp[0][i] = i;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][ j - 1];
                } else {

                    int insert = dp[i][j - 1];
                    int delete = dp[i - 1][j];
                    int replace = dp[i - 1][j - 1];

                    dp[i][j] = 1 + Math.min(insert,
                            Math.min(delete, replace));
                }
            }
        }

        return dp[n][m];
    }

    private int helper(int i, int j, String s1, String s2, int[][] dp) {

        if (i == 0) {
            return j;
        }

        if (j == 0) {
            return i;
        }

        if (dp[i - 1][j - 1] != -1) {
            return dp[i - 1][j - 1];
        }

        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            return dp[i - 1][j - 1] = helper(i - 1, j - 1, s1, s2, dp);
        }

        int insert = helper(i, j - 1, s1, s2, dp);
        int delete = helper(i - 1, j, s1, s2, dp);
        int replace = helper(i - 1, j - 1, s1, s2, dp);

        return dp[i - 1][j - 1] = 1 + Math.min(insert,
                Math.min(delete, replace));
    }
}