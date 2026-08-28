class Solution {
    String ans = "";
    char mid = '#';
    public String lexPalindromicPermutation(String s, String target) {
        int[] freq = new int[26];
        int n = s.length();

        for(char c: s.toCharArray()){
            freq[c-'a']++;
        }

        int odd = 0;
        for(int i=0;i<26;i++){
            if(freq[i]%2!=0){
                odd++;
                mid = (char)('a'+i);
            }
        }

        if(odd>1) return "";

        for(int i=0;i<26;i++){
            freq[i] = freq[i]/2;
        }

        int half = n/2;
        StringBuilder curr = new StringBuilder();

        solve(curr,target,freq,0,false);
        return ans;
    }

    private boolean solve(StringBuilder curr, String target, int[] freq, int i, boolean greater){

        if(i==target.length()/2){
            String temp = curr.toString();
            
            if(mid!='#') temp += mid;

            temp += new StringBuilder(curr).reverse().toString();

            if(temp.compareTo(target)>0){
                ans = temp;
                return true;
            }
            return false;
        }

        for(char c='a'; c<='z';c++){

            if(freq[c-'a']==0) continue;

            if(!greater && c<target.charAt(i)) continue;

            curr.append(c);
            freq[c-'a']--;

            boolean isGreater = c>target.charAt(i) || greater;

            if(solve(curr,target,freq,i+1,isGreater)) return true;

            curr.deleteCharAt(curr.length() - 1);
            freq[c-'a']++;

        }

        return false;
    }
}