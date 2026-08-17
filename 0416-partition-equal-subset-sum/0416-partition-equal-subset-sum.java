class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // Odd total cannot be divided equally
        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;

        int[][] dp = new int[n + 1][target + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(n, target, nums, dp);
    }

    private boolean helper(int i, int target, int[] nums, int[][] dp) {

        // Found required subset
        if (target == 0) {
            return true;
        }

        // No elements left
        if (i == 0) {
            return false;
        }

        if (dp[i][target] != -1) {
            return dp[i][target] == 1;
        }

        // Don't take nums[i-1]
        boolean not = helper(i - 1, target, nums, dp);

        // Take nums[i-1]
        boolean take = false;

        if (nums[i - 1] <= target) {
            take = helper(
                i - 1,
                target - nums[i - 1],
                nums,
                dp
            );
        }

        boolean ans = take || not;

        dp[i][target] = ans ? 1 : 0;

        return ans;
    }
}