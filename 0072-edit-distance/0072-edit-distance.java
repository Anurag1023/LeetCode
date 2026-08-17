class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n+1][m+1];

        for (int[] row : dp) {
            java.util.Arrays.fill(row, -1);
        }

        return helper(n, m, word1, word2, dp);
    }

    private int helper(int i, int j, String s1, String s2, int[][] dp) {

        if (i == 0) {
            return j;
        }

        if (j == 0) {
            return i;
        }

        if (dp[i-1][j-1] != -1) {
            return dp[i-1][j-1];
        }

        if (s1.charAt(i-1) == s2.charAt(j-1)) {
            return dp[i-1][j-1] = helper(i - 1, j - 1, s1, s2, dp);
        }

        int insert = helper(i, j - 1, s1, s2, dp);
        int delete = helper(i - 1, j, s1, s2, dp);
        int replace = helper(i - 1, j - 1, s1, s2, dp);

        return dp[i-1][j-1] = 1 + Math.min(insert,
                                Math.min(delete, replace));
    }
}