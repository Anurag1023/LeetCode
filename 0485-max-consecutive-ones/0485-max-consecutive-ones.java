class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int cnt = 0;
        int max =0;
        for(int n: nums){
            if(n==1)cnt++;
            else{
                cnt=0;
            }
            max = Math.max(max,cnt);
        }
        return max;
    }
}