class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }

        for (int i = 0; i <= t.length(); i++) {
            dp[s.length()][i] = 0;
        }
        
        for (int i = 0; i <= s.length(); i++) {
            dp[i][t.length()] = 1;
        }


        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = t.length() - 1; j >= 0; j--) {

                int not = dp[i + 1][j];
                int take = 0;
                if (s.charAt(i) == t.charAt(j)) {
                    take = dp[i + 1][j + 1];
                }

                dp[i][j] = take + not;
            }
        }

        return dp[0][0];
    }

    private int helper(String s, String t, int i, int j, int[][] dp) {

        if (j == t.length()) {
            return 1;
        }

        if (i == s.length()) {
            return 0;
        }

        if (dp[i][j] != -1)
            return dp[i][j];

        int not = helper(s, t, i + 1, j, dp);
        int take = 0;
        if (s.charAt(i) == t.charAt(j)) {
            take = helper(s, t, i + 1, j + 1, dp);
        }

        return dp[i][j] = take + not;
    }
}