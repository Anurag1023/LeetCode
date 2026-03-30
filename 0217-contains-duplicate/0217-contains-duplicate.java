class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hs = new HashSet<>();
        for(int n: nums){
            if(hs.contains(n)){ return true;}
            else{
                hs.add(n);
            }
        }
        return false;
    }
}