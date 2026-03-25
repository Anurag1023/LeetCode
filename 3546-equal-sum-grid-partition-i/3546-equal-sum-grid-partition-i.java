class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        long total = 0;

        long[] colSum = new long[n];
        long[] rowSum = new long[m];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                total += grid[i][j];
                colSum[j] += grid[i][j];
                rowSum[i] += grid[i][j];
            }
        }

        long left = 0;
        for(int j = 0; j < n - 1; j++){
            left += colSum[j];
            if(left == total - left) return true;
        }

        long top = 0;
        for(int i = 0; i < m - 1; i++){
            top += rowSum[i];
            if(top == total - top) return true;
        }

        return false;
    }
}