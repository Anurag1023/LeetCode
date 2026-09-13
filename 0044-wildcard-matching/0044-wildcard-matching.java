class Solution {
    private int[][] dp;

    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        dp = new int[n][m];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, 0, s, p);
    }

    private boolean solve(int i, int j, String s, String p) {

        // Both strings completely matched
        if (i == s.length() && j == p.length()) {
            return true;
        }

        // Pattern exhausted but string remains
        if (j == p.length()) {
            return false;
        }

        // String exhausted
        if (i == s.length()) {
            // Remaining pattern must contain only '*'
            for (int k = j; k < p.length(); k++) {
                if (p.charAt(k) != '*') {
                    return false;
                }
            }
            return true;
        }

        if (dp[i][j] != -1) {
            return dp[i][j] == 1;
        }

        boolean ans;

        char sc = s.charAt(i);
        char pc = p.charAt(j);

        if (pc == '*') {

            // '*' matches zero characters
            boolean zero = solve(i, j + 1, s, p);

            // '*' matches one or more characters
            boolean oneOrMore = solve(i + 1, j, s, p);

            ans = zero || oneOrMore;

        } else if (pc == '?' || sc == pc) {

            ans = solve(i + 1, j + 1, s, p);

        } else {
            ans = false;
        }

        dp[i][j] = ans ? 1 : 0;

        return ans;
    }
}