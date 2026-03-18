class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        int[] pos = new int[26];
        Arrays.fill(pos,-1);

        for(int i=0;i<s.length(); i++){
            pos[s.charAt(i)-'a'] =i;
        }

        int maxLen = 0;
        int idx=0;

        for(int i=0;i<s.length(); i++){
            maxLen = Math.max(pos[s.charAt(i)-'a'], maxLen);
            if(i==maxLen){
                ans.add(i-idx+1);
                idx=i+1;
                maxLen=0;
            }
        }
        return ans;
    }
}