class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        for (String s : queries) {
            isValid(s, dictionary);
        }
        return ans;
    }

    private void isValid(String s, String[] dictionary) {
        for (String word : dictionary) {
            int max = 2;
            if (s.length() != word.length())
                continue;
            for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) != word.charAt(i))
                        max--;
                    if(max<0) break;
            }
            if (max >= 0){
                ans.add(s);
                break;
            }
        }
    }
}