class Solution {
    public int smallestNumber(int n, int t) {

        int num = helper(n,t);

        while(num%t!=0){
            num = helper(++n,t);
        }
        return n;
    }

    private int helper(int n,int t){
        int num = n, mul = 1;
        while(num>0){
            mul *= num%10;
            num /= 10;
        }
        return mul;
    }
}