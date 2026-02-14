class Solution {
    public void dfs(int [][] image, int i,int j, int newcolor, int orcolor){
        if(i<0 || j<0 || i >= image.length || j >= image[0].length ||
        image[i][j]!=orcolor || image[i][j]==newcolor){
            return;
        } 
        
        image[i][j] = newcolor;


        dfs(image,i-1,j,newcolor,orcolor);//top
        dfs(image,i,j+1,newcolor,orcolor);//right
        dfs(image,i+1,j,newcolor,orcolor);//bottom
        dfs(image,i,j-1,newcolor,orcolor);//left

    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        dfs(image, sr, sc, color, image[sr][sc]);
        return image;
        
    }
}