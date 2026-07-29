class Solution {
    public int strStr(String haystack, String needle) {
        int size = needle.length();

        for(int i=0; i< haystack.length() - size +1; i++){
            String temp = haystack.substring(i,i+size);
            if(temp.equals(needle)) return i;
        }
        return -1;
    }
}