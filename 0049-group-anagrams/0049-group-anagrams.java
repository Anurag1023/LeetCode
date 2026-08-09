class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        boolean[] visited = new boolean[strs.length];
        List<List<String>> res = new ArrayList<>();

        for(int i=0;i<strs.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            List<String> ans = new ArrayList<>();
            ans.add(strs[i]);
            for(int j=0;j<strs.length;j++){
                if(!visited[j] && isAnagram(strs[i],strs[j])){
                    ans.add(strs[j]);
                    visited[j]=true;
                }
            }
            res.add(ans);
        }
        return res;
    }

    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> m1 = new HashMap<>();

        if (s.length() != t.length())
            return false;

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            m1.put(a, m1.getOrDefault(a, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char a = t.charAt(i);
            if (!m1.containsKey(a))
                return false;
            m1.put(a, m1.get(a) - 1);
        }

        for (Integer val : m1.values()) {
            if (val != 0)
                return false;
        }

        return true;
    }
}