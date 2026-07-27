class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int first = 0;
        int second = 0;

        for(int i=0; i<n;i++){
            if(nums[i] > first){
                second = first;
                first = nums[i];
            }else if(nums[i] <= first && nums[i] > second){
                second = nums[i];
            }
        }

        return (first-1)*(second-1);

    }
}