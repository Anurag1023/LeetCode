class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length+1][nums.length];
        for(int[] a: dp) Arrays.fill(a,-1);
        return helper(-1, 0, nums,dp);
    }

    private int helper(int prev, int curr, int[] nums, int[][] dp) {
        if (curr == nums.length) {
            return 0;
        }

        if(dp[prev+1][curr]!=-1) return dp[prev+1][curr];

        int not = helper(prev, curr + 1, nums,dp);

        int take = 0;

        if (prev == -1 || nums[curr] > nums[prev]) {
            take = 1 + helper(curr, curr + 1, nums,dp);
        }

        return dp[prev+1][curr] = Math.max(take, not);
    }
}