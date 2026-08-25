class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> hs = new HashSet<>();
        for(int num:nums){
            hs.add(num);
        }
        int i=1;
        while(true){
            if(!hs.contains(k*i))return k*i;
            i++;
        }
    }
}