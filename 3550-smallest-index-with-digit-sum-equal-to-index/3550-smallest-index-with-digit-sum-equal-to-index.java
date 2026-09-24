class Solution {
    public int smallestIndex(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int x = helper(nums[i]);
            if(x==i)return i;
        }   
        return -1;
    }

    private int helper(int num){
        int ans = 0;
        while(num>0){
            ans += num%10;
            num /= 10;
        }
        return ans;
    }
}