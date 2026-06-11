class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n][m];


        for(int[] row:dp){
            Arrays.fill(row,-1);
        }

        return helper(grid,0,0,dp);
    }

    private int helper(int[][] grid, int posX, int posY, int[][] dp){
        int n = grid.length;
        int m = grid[0].length;

        if(posX>=n || posY>= m) return (int)1e9;

        if(posX == n-1 && posY == m-1) return grid[posX][posY];

        if(dp[posX][posY]!=-1)return dp[posX][posY];

        return dp[posX][posY] = grid[posX][posY] + Math.min(helper(grid,posX+1,posY,dp), helper(grid,posX,posY+1,dp));
    }
}