class Solution {
    public long makeIntegerBeautiful(long n, int target) {
        int ans = helper(n);
        if(ans <= target) return 0;

        long base = 10;
        long temp = n;

        while(ans>target){
            long rem = temp % base;
            temp = temp + base - rem;
            ans = helper(temp);
            base *= 10;
        }

        return temp - n;
    }

    private int helper(long n){
        int num = 0;
        while(n>0){
            num += n%10;
            n /= 10;
        }
        return num;
    }
}