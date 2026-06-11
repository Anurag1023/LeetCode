class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        int[][] dp = new int[n][m];


        for(int[] row:dp){
            Arrays.fill(row,-1);
        }

        return helper(obstacleGrid,0,0,dp);
    }

    private int helper(int[][] grid, int posX, int posY, int[][] dp){
        
        int n = grid.length;
        int m = grid[0].length;

        if(grid[n-1][m-1]==1) return 0;

        if(posX>=  n|| posY>=m ) return 0;

        if(posX == n-1 && posY == m-1)return 1;

        if(grid[posX][posY]==1) return 0;

        if(dp[posX][posY]!=-1) return dp[posX][posY];

        return dp[posX][posY] = helper(grid,posX+1,posY,dp) + helper(grid,posX,posY+1,dp);
    }
}