class Solution {

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int cnt = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1' && vis[i][j] == 0){
                    cnt++;
                    bfs(grid, vis, i, j);
                }
            }
        }
        return cnt;
    }

    private void bfs(char[][] grid, int[][] vis, int i, int j){
        Queue<int[]> q = new LinkedList<>();
        vis[i][j] = 1;
        q.offer(new int[]{i, j});

        int n = grid.length;
        int m = grid[0].length;

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        while(!q.isEmpty()){
            int[] data = q.poll();
            int row = data[0];
            int col = data[1];

            for(int k = 0; k < 4; k++){
                int nrow = row + drow[k];
                int ncol = col + dcol[k];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m 
                   && grid[nrow][ncol] == '1' && vis[nrow][ncol] == 0){
                    vis[nrow][ncol] = 1;
                    q.offer(new int[]{nrow, ncol});
                }
            }
        }
    }
}