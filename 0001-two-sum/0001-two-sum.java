class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] arr = {-1,-1};
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            if(hm.containsKey(target-num)){
                return new int[]{hm.get(target-num),i};
            }
            hm.put(num,i);
        }

        return arr;
    }
}