class Solution {
    public int minPartitions(String n) {
        int max = 0;
        for(int i=(n.length()-1); i>=0;i--){
            int cnt = n.charAt(i)-'0';
            max=Math.max(cnt,max);
            if(max==9) return max;
        }
        return max;
    }
}