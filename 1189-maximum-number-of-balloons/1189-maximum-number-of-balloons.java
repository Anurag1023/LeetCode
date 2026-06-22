class Solution {
    public int maxNumberOfBalloons(String text) {
        int char_b = 0;
        int char_a = 0;
        int char_l = 0;
        int char_o = 0;
        int char_n = 0;

        for(char c: text.toCharArray()){
            if(c=='b') char_b++;
            else if(c=='a') char_a++;
            else if(c=='l') char_l++;
            else if(c=='o') char_o++;
            else if(c=='n') char_n++;
        }

        int cnt=0;
        while(char_b>0){
            if(char_a>0 && char_l>1 && char_o>1 && char_n>0){
                cnt++;
                char_a--;
                char_b--;
                char_l -= 2;
                char_o-=2;
                char_n--;
            }
            else return cnt;
        }
        return cnt;
    }
}