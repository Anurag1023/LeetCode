class Solution {
    public boolean checkOnesSegment(String s) {
        if(s.length()<2)return true;
        for(int i=1; i<s.length();i++){
            char num1 = s.charAt(i);
            char num2 = s.charAt(i-1);
            if(num1=='1' && num2=='0') return false;
        }
        return true;
    }
}