class Solution {
    public int climbStairs(int n) {
        if(n<3) return n;

        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;

        int first = 2;
        int sec = 1;

        int curr = 0;
        for(int i=3;i<=n;i++){
            curr = first+sec;
            sec= first;
            first = curr;
        }

        return curr;

    }
}