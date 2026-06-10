class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        return Math.max( helper(nums,0,n-2), helper(nums,1,n-1));
    }

    private int helper(int[] nums, int start, int end){
        
        int prev1 = 0;
        int prev2 = 0;

        for(int i=start; i<= end; i++){
            
            int take = nums[i];
            if(i>1) take+= prev2;
            int notTake = prev1;

            int curr = Math.max(take, notTake);

            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}