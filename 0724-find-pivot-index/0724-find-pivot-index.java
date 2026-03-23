class Solution {
    public int pivotIndex(int[] nums) {
        int[] prefix =new int[nums.length+1];
        int sum=0;
        prefix[0]=0;
        for(int i = 1; i<prefix.length; i++){
            sum+=nums[i-1];
            prefix[i] = sum;
        }

        for(int i = 1; i<prefix.length; i++){
            if(prefix[i-1] == prefix[prefix.length-1] - prefix[i]) return i-1;
        }
        
        return -1;
    }
}