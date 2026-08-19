class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        
        String target = helper(pattern);
        List<String> res = new ArrayList<>();

        for(String word: words){
            if(helper(word).equals(target)) res.add(word);
        }

        return res;
    }

    private String helper(String pattern){
        int n = pattern.length();
        StringBuilder st = new StringBuilder();
        Map<Character, Integer> hm = new HashMap<>();

        int cnt = 0;
        for(char c: pattern.toCharArray()){
            if(!hm.containsKey(c)){
                hm.put(c,cnt++);
            }
            st.append(hm.get(c)).append("-");
        }

        return st.toString();
    }
}