class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int max = 0;
        int n = nums.length;
        int l = 0;
        Map<Integer, Integer> hm = new HashMap<>();

        for(int r=0;r<n;r++){
            hm.put(nums[r], hm.getOrDefault(nums[r],0)+1);

            while(hm.get(nums[r])>k && l<r){
                hm.put(nums[l], hm.get(nums[l])-1);
                l++;
            }

            max = Math.max(max, r-l+1);
        }   
        return max;
    }
}