class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer,String> hm = new HashMap<>();
        int n = names.length;

        for(int i=0;i<n;i++){
            hm.put(heights[i],names[i]);
        }

        Arrays.sort(heights);

        for(int i=n-1;i>=0;i--){
            names[n-i-1] = hm.get(heights[i]);
        }
        return names;
    }
}