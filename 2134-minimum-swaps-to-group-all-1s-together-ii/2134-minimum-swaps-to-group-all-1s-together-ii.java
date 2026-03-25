class Solution {
    public int minSwaps(int[] nums) {
        int cnt1 = 0;
        for(int n: nums){
            cnt1+=n;
        }

        if(cnt1==0) return 0;

        int min = Integer.MAX_VALUE;
        int l=0;
        int n=nums.length;

        int cnt=0;

        for(int r=0;r<2*n;r++){
            cnt+=nums[r%n];

            while(r-l+1>cnt1){
                cnt-=nums[l%n];
                l++;
            }

            if(r-l+1==cnt1) min = Math.min(min, r-l+1 - cnt);
        }

        return min;
    }
}