class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums,res,0);
        return res;        
    }

    private void helper(int[] nums, List<List<Integer>> res, int n){
        if(n==nums.length){
            List<Integer> temp = new ArrayList<>();
            for(int num: nums){
                temp.add(num);
            }
            res.add(temp);
            return;
        }

        for(int i=n;i<nums.length;i++){
            swap(i,n,nums);
            helper(nums,res,n+1);
            swap(i,n,nums);
        }
    }

    private void swap(int i,int n, int[] nums){
        int temp = nums[i];
        nums[i]=nums[n];
        nums[n] = temp;
    }

}