class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];

        for(int[] arr: dp){
            Arrays.fill(arr,-1);
        }
        
        int ans = helper(coins,amount,n-1,dp);
        return ans==(int)1e9?-1:ans;
    }

    private int helper(int[] nums, int target, int ind, int[][] dp){
        if(target==0) return dp[ind][target] = 0;

        if(ind==0){
            if(target%nums[ind]==0){
                return target/nums[ind];
            }
            else return (int)1e9;
        }

        if(dp[ind][target]!=-1) return dp[ind][target];
        int take = (int)1e9;
        if(target>=nums[ind]) take = 1 + helper(nums,target-nums[ind], ind,dp);
        int notTake = helper(nums,target, ind-1,dp);
        return dp[ind][target] = Math.min(take, notTake);
    }
}