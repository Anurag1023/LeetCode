class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int l = 0;
        for(int r=0;r<nums.length;r++){
            sum+=nums[r];
            max = Math.max(max,sum);
            while(l<=r && sum<=0){
                max = Math.max(max,sum);
                sum-=nums[l];
                l++;
            }
        }
        return max;
    }
}