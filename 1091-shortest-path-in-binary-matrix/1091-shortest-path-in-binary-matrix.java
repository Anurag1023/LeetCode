class tuple{
    int first, second, third;
    tuple(int _first, int _second, int _third){
        this.first = _first;
        this.second = _second;
        this.third = _third;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if(grid[0][0] == 1) return -1;
        if(n == 1 && m == 1) return 1;

        Queue<tuple> q = new LinkedList<>();
        int[][] dist = new int[n][m];

        for(int[] i: dist){
            Arrays.fill(i, (int)1e9);
        }

        dist[0][0] = 1;
        q.offer(new tuple(1,0,0));

        int[][] dir = {
            {0,1},{1,0},{0,-1},{-1,0},
            {1,1},{1,-1},{-1,1},{-1,-1}
        };

        while(!q.isEmpty()){
            tuple node = q.poll();
            int dis = node.first;
            int row = node.second;
            int col = node.third;

            for(int[] d : dir){
                int nrow = row + d[0];
                int ncol = col + d[1];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m &&
                   grid[nrow][ncol]==0 && dis+1<dist[nrow][ncol]){

                    dist[nrow][ncol] = dis+1;

                    if(nrow == n-1 && ncol == m-1) return dis+1;

                    q.offer(new tuple(dis+1,nrow,ncol));
                }
            }
        }
        return -1;
    }
}