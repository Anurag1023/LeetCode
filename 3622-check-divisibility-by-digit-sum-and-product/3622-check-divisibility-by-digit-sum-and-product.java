class Solution {
    public boolean checkDivisibility(int n) {
        int temp = n;
        int sum=0;
        int product = 1;

        while(temp!=0){
            sum += temp%10;
            temp /= 10;
        }

        temp=n;
        while(temp!=0){
            product *= temp%10;
            temp /= 10;
        }

        return n%(sum+product)==0;
    }
}