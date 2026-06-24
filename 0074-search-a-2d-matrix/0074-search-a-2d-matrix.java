class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        for(int i=0;i<n;i++){
            if(matrix[i][m-1]>=target) return binarySearch(matrix,target,i);
        }

        return false;
    }

    private boolean binarySearch(int[][] matrix, int target, int i){

        int n = matrix[0].length;

        int first = 0;
        int last = n-1;


        while(first<=last){
            int mid = first + (last-first)/2;
            if(matrix[i][mid]==target) return true;
            else if(matrix[i][mid]>target) last = mid-1;
            else if(matrix[i][mid]<target) first = mid+1;
        }

        return false;
    }
}