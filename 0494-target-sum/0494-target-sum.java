class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        return helper(nums,target,n-1);
    }

    private int helper(int[] nums, int target, int ind){
        if(ind<0){
            if(target==0) return 1;
            else return 0;
        }

        int add = helper(nums,target+nums[ind],ind-1);
        int sub = helper(nums,target-nums[ind],ind-1);

        return add+sub;
    }
}