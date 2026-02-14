class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        
        int originalColor = image[sr][sc];
        
        // Edge case
        if (originalColor == color) return image;
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc});
        image[sr][sc] = color;
        
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            
            for (int[] dir : directions) {
                int r = curr[0] + dir[0];
                int c = curr[1] + dir[1];
                
                if (r >= 0 && r < n && c >= 0 && c < m 
                    && image[r][c] == originalColor) {
                    
                    image[r][c] = color;
                    q.offer(new int[]{r, c});
                }
            }
        }
        
        return image;
    }
}
