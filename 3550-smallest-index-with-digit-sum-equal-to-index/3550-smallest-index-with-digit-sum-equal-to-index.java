class Solution {
    public int smallestIndex(int[] nums) {
        int[] arr = new int[1001];
        Arrays.fill(arr,-1);
        for(int i=0;i<nums.length;i++){
            if(arr[nums[i]]==-1){
                arr[nums[i]] = helper(nums[i]);
            }
            if(arr[nums[i]]==i)return i;
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