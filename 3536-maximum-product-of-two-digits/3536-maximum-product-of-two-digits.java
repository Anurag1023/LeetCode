class Solution {
    public int maxProduct(int n) {
        int largest = 0;
        int second = 0;

        while(n>0){
            int num = n%10;
            if(num>largest){
                second = largest;
                largest = num;
            }else if(num > second && num <= largest) second = num;

            n /= 10;
        }

        return largest * second;
    }
}