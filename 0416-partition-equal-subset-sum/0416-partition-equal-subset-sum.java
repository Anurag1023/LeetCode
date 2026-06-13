class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int x : nums) sum += x;

        if(sum % 2 != 0) return false;

        int target = sum / 2;

        Boolean[][] dp = new Boolean[nums.length][target + 1];

        return helper(nums, nums.length - 1, target, dp);
    }

    private boolean helper(int[] nums, int ind, int target, Boolean[][] dp) {
        if(target == 0) return true;
        if(ind < 0 || target < 0) return false;

        if(dp[ind][target] != null)
            return dp[ind][target];

        return dp[ind][target] =
                helper(nums, ind - 1, target, dp) ||
                helper(nums, ind - 1, target - nums[ind], dp);
    }
}