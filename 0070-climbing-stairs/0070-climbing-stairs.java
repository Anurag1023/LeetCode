class Solution {
    public int climbStairs(int n) {
        if(n<3) return n;

        int[] dp = new int[2];
        dp[0] = 1;
        dp[1] = 2;

        int curr = 0;
        for(int i=3;i<=n;i++){
            curr = dp[0] + dp[1];
            dp[0]=dp[1];
            dp[1] = curr;
        }

        return curr;

    }
}