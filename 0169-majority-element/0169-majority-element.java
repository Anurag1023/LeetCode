class Solution {
    public int majorityElement(int[] nums) {
        int cnt = 0;
        int ans = nums[0];

        for(int num: nums){
            if(cnt==0){
                ans = num;
            }
            if(ans!=num){
                cnt--;
            }else{
                cnt++;
            }
        }
        return ans;
    }
}