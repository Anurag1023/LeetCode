class Solution {
    public int[] transformArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int even =0;
        for(int i=0;i<n;i++){
            if((nums[i] & 1) == 0) even++;
        }

        for(int i=0;i<even;i++){
            ans[i]=0;
        }

        for(int i=even;i<n;i++) ans[i]=1;

        return ans;
    }
}