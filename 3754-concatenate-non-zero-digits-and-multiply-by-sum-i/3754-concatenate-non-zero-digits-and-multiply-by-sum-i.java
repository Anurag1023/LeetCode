class Solution {
    public long sumAndMultiply(int n) {
        long sum = 0;
        long num = 0;
        long carry = 1;

        while(n>0){
            int last = n%10;
            n /= 10;
            if(last == 0) continue;
            sum += last;
            num += last*carry;
            carry *= 10;
        }

        return num*sum;
    }
}