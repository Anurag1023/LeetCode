class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int r=0;r<nums.length;r++){
            sum = Math.max(sum+nums[r],nums[r]);
            max = Math.max(max,sum);
        }
        return max;
    }
}