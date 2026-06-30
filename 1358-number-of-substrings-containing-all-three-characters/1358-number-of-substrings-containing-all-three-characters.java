class Solution {
    public int numberOfSubstrings(String s) {
        int l = 0;
        int[] ch = new int[3];
        int cnt = 0;
        for(int r=0;r<s.length();r++){
            char c = s.charAt(r);
            ch[c-'a']++;
            while(ch[0]>0 && ch[1]>0 && ch[2]>0){
                c = s.charAt(l);
                ch[c-'a']--;
                l++;
            }
            cnt += l;
        }
        return cnt;
    }
}