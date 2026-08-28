class Solution {
    String ans ="";
    public String lexGreaterPermutation(String s, String target) {
        int[] freq = new int[26];

        for(char c: s.toCharArray()){
            freq[c-'a']++;
        }

        StringBuilder curr = new StringBuilder();
        solve(curr,target,freq,0,false);
        return ans;
    }

    private boolean solve(StringBuilder curr, String target, int[] freq, int i, boolean greater){

        if(i==target.length()){
            if(greater){
                ans = curr.toString();
                return true;
            }
            return false;
        }

        for(char c='a'; c<='z';c++){
            if(freq[c-'a']==0)continue;

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