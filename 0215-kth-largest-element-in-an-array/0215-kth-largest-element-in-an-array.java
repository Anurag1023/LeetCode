class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for(int n:nums){
            pq.offer(n);
        }

        while(k>1){
            pq.poll();
            k--;
        }
        return pq.poll();
    }
}