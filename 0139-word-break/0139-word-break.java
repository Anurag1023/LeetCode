class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for(int[] a: dp){
            Arrays.fill(a,-1);
        }

        return solve(0,0,s, new HashSet<>(wordDict), dp);
    }

    private boolean solve(int start, int end, String s, HashSet<String> hs, int[][] dp){

        if(dp[start][end] != -1) return dp[start][end] == 1;

        if(end == s.length()-1){
            if(hs.contains(s.substring(start,end+1))) return true;
            else return false;
        }

        if(hs.contains(s.substring(start,end+1))){
            if(solve(end+1,end+1,s,hs,dp)){
                dp[start][end] = 1;
                return true;
            }
        }

        boolean ans  = solve(start,end+1,s,hs,dp);
        dp[start][end] = ans?1:0;
        return ans;
    }
}