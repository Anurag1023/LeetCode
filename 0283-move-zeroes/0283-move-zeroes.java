class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int l=-1;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                l=i;
                break;
            }
        }
        if(l==-1) return;
        for(int r=0;r<n;r++){
            if(nums[r]!=0 && l<r){
                nums[l]=nums[r];
                nums[r]=0;
                l++;
            }
        }
    }
}