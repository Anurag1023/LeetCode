class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        String ans = "";
        for(String word: words){
            int sum = 0;
            for(char c: word.toCharArray()){
                sum += weights[c-'a'];
            }

            int mod = sum%26;
            ans = ans + (char)('a'+25-mod);
        }
        return ans;
    }
}