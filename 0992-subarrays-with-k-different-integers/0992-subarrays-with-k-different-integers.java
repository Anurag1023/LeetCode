class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return sub(nums,k) - sub(nums, k-1);
    }

    public int sub(int[] nums, int k){
        int l=0;
        int cnt=0;
        Map<Integer, Integer> mpp = new HashMap<>();

        for(int r=0;r<nums.length;r++){
            mpp.put(nums[r], mpp.getOrDefault(nums[r],0)+1);
            if(mpp.get(nums[r])==1) k--;

            while(k<0){
                mpp.put(nums[l], mpp.getOrDefault(nums[l],0)-1);
                if(mpp.get(nums[l])==0) k++;
                l++;
            }

            cnt+= r-l+1;
        }

        return cnt;
    }
}