class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> hm = new HashMap<>();
        Stack<Integer> st = new Stack<>();

        for(int n: nums2){
            while(!st.isEmpty() && n>st.peek()){
                hm.put(st.pop(),n);
            }
            st.push(n);
        }

        while(!st.isEmpty()){
            hm.put(st.pop(),-1);
        }

        int[] ans = new int[nums1.length];

        for(int i=0;i<nums1.length; i++){
            ans[i] = hm.get(nums1[i]);
        }

        return ans;
    }
}