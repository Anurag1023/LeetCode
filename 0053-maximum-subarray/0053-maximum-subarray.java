class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int l=0;
        for(int r=0;r<nums.length;r++){
            sum += nums[r];
            max = Math.max(max,sum);
            while(sum<0 && l<=r){
                sum -= nums[l];
                l++;
            }
        }
        return max;
    }
}