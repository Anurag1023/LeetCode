class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int sum = 0;
        int len = Integer.MAX_VALUE;
        for(int r=l; r<nums.length;r++){
            sum += nums[r];
            if(sum>=target){
                len = Math.min(len, r-l+1);
            }
            while(sum>=target && l<=r){
                len = Math.min(len, r-l+1);
                sum-=nums[l];
                l++;
            }
        }
        return len==Integer.MAX_VALUE?0:len;
    }
}