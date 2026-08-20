class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) return nums[0];

        return Math.max(
            helper(nums, 0, n - 2),
            helper(nums, 1, n - 1)
        );
    }

    private int helper(int[] nums, int start, int end) {
        int len = end - start + 1;
        int[] dp = new int[len + 1];

        dp[0] = 0;
        dp[1] = nums[start];

        for (int i = 2; i <= len; i++) {
            int take = nums[start + i - 1] + dp[i - 2];
            int notTake = dp[i - 1];

            dp[i] = Math.max(take, notTake);
        }

        return dp[len];
    }
}