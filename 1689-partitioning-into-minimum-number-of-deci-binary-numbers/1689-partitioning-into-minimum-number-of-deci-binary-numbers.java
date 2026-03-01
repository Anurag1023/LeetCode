class Solution {
    public int minPartitions(String n) {
        int max = 0;
        for(int i=0; i<n.length();i++){
            int cnt = n.charAt(i)-'0';
            max=Math.max(cnt,max);
            if(max==9) return max;
        }
        return max;
    }
}