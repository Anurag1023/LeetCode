class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> hm= new HashMap<>();
        for(List<String> ls: knowledge){
            hm.put(ls.get(0),ls.get(1));
        }

        StringBuilder st = new StringBuilder();

        for(int i=0;i<s.length();i++){

            char c = s.charAt(i);
            if(c=='('){
                StringBuilder temp = new StringBuilder();
                i++;
                while(s.charAt(i)!=')'){
                    temp.append(s.charAt(i));
                    i++;
                }
                
                if(hm.containsKey(temp.toString())){
                    st.append(hm.get(temp.toString()));
                }else{
                    st.append("?");
                }
            }else{
                st.append(c);
            }
        }

        return st.toString();
    }
}