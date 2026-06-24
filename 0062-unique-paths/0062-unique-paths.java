class Solution {
    public int uniquePaths(int m, int n) {
        if(m==1) return 1;
        int[][] dp = new int[m][n];

        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        return helper(m,n,0,0,dp);
    }

    private int helper(int m, int n, int x, int y,int[][] dp){
        if(x==m-1 && y==n-1) return 1;
        if(x>=m || y>=n) return 0;

        if(dp[x][y]!=-1) return dp[x][y];

        return dp[x][y] = helper(m,n,x,y+1,dp) +  helper(m,n,x+1,y,dp);
    }
}