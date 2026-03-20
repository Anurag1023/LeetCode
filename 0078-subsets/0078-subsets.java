class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        subset(0,nums,arr,ans);
        return ans;
    }

    private void subset(int a, int[] nums,List<Integer> arr,List<List<Integer>> ans){
        if(a==nums.length){
            ans.add(new ArrayList<>(arr));
            return;
        }
        arr.add(nums[a]);
        subset(a+1,nums,arr,ans);
        arr.remove(arr.size() - 1);
        subset(a+1,nums,arr,ans);
    }
}