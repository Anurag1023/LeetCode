class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        
        for (int i = x; i < x + k / 2; i++) {
            for (int j = y; j < y + k; j++) {
                
                int oppositeRow = x + k - 1 - (i - x);
                
                int temp = grid[i][j];
                grid[i][j] = grid[oppositeRow][j];
                grid[oppositeRow][j] = temp;
            }
        }
        
        return grid;
    }
}