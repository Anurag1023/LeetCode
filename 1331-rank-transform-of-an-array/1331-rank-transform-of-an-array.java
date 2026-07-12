class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] temp = arr.clone();
        Arrays.sort(temp);
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = arr.length;
        int rank = 1;
        for(int i=0;i<n;i++){
            if(!hm.containsKey(temp[i])) hm.put(temp[i],rank++);
        }

        for(int i=0;i<n;i++){
            temp[i] = hm.get(arr[i]);
        }
        return temp;
    }
}