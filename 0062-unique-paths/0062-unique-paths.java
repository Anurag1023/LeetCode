class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for(int[] row: dp){
            Arrays.fill(row, -1);
        }

        return helper(m,n,0,0,dp);
    }

    private int helper(int m, int n, int posx,int posy, int[][] dp){
        if(posx>=m || posx<0 || posy>=n || posy<0) return 0;
        if(posx == m-1 && posy==n-1) return 1;

        if(dp[posx][posy]!=-1) return dp[posx][posy];

        return dp[posx][posy] = helper(m,n,posx+1,posy,dp) + helper(m,n,posx,posy+1,dp);
    }
}