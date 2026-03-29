class Solution {
    public int minAbsoluteDifference(int[] nums) {
        int min = Integer.MAX_VALUE;
        int idx1=-1;
        int idx2 = -1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                if(idx2>-1 && min>=Math.abs(i-idx2)){
                    min= Math.abs(i-idx2);
                }
                idx1=i;
            }else if(nums[i]==2 ){
                if(idx1>-1 && min>=Math.abs(i-idx1)){
                    min= Math.abs(i-idx1);
                }
                idx2=i;
            }
        }
        return min==Integer.MAX_VALUE?-1:min;
    }
}