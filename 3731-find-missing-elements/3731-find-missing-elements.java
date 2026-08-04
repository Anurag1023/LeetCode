class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        HashSet<Integer>  hm = new HashSet<>();

        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;
        int n = nums.length;

        for(int i=0;i<n;i++){
            smallest = Math.min(smallest, nums[i]);
            largest = Math.max(largest, nums[i]);

            hm.add(nums[i]);
        }

        List<Integer> arr = new ArrayList<>();

        for(int i=smallest+1;i<largest;i++){
            if(!hm.contains(i)) arr.add(i);
        }

        return arr;
    }
}