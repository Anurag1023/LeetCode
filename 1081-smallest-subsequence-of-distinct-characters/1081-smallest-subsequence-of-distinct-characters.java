class Solution {
    public String smallestSubsequence(String s) {
        int n = s.length();
        int[] last = new int[26];

        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            last[c-'a'] = i;
        }
        Stack<Integer> st = new Stack<>();
        HashSet<Character> hs = new HashSet<>();

        for(int i=0; i<n; i++){
            char c = s.charAt(i);

            if(hs.contains(c)) continue;

            while(!st.isEmpty()){
                char prev = s.charAt(st.peek());
                if(prev > c && last[prev -'a'] > i){
                    st.pop();
                    hs.remove(prev);
                }else break;
            }

            hs.add(c);
            st.push(i);
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(s.charAt(st.pop()));
        }

        return sb.reverse().toString();
    }
}