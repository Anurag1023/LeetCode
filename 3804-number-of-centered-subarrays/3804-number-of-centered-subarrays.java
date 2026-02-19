class Solution {
    public int centeredSubarrays(int[] nums) {
        int cnt = 0;
        for(int right = 0; right < nums.length; right++){
            HashSet<Integer> hs = new HashSet<>();
            int sum = 0;
            for(int i=right; i<nums.length; i++){
                sum+=nums[i];
                hs.add(nums[i]);
                if(hs.contains(sum)) cnt++;
            }
            hs.remove(nums[right]);
        }
        return cnt;
    }
}