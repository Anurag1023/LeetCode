class Solution {
    public boolean hasAlternatingBits(int n) {
        while(n>0){
            int last = n&1;
            n=n>>1;
            if(last == (n&1)){
                return false;
            }
        }
        return true;
    }
}