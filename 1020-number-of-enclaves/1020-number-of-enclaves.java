class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        // Step 1: Remove boundary connected land
        for(int i = 0; i < n; i++){
            dfs(grid, i, 0);
            dfs(grid, i, m-1);
        }

        for(int j = 0; j < m; j++){
            dfs(grid, 0, j);
            dfs(grid, n-1, j);
        }

        // Step 2: Count remaining land
        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1) cnt++;
            }
        }

        return cnt;
    }

    private void dfs(int[][] grid, int i, int j){
        int n = grid.length;
        int m = grid[0].length;

        if(i<0 || i>=n || j<0 || j>=m || grid[i][j]==0) return;

        grid[i][j] = 0;

        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
    }
}