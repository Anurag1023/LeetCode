class Solution {
    public int maximumTop(int[] nums, int k) {
        if ( nums.length == 1 ) return k % 2 == 0 ? nums[0] : -1;
        
        int max = -1;
        for ( int i = 0; i < nums.length && i < k-1; i++ )
            max = Math.max(max, nums[i]);
        if ( k < nums.length ) max = Math.max(max, nums[k]);

        return max;
    }
}