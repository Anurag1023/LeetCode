class Solution {
    public int largestAltitude(int[] gain) {
        int curr=0;
        int max = 0;
        for(int num: gain){
            curr += num;
            max = Math.max(max,curr);
        }
        return max;
    }
}