class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = 0, day = 0, ans = 0;
        int n = events.length;

        while (i < n || !pq.isEmpty()) {

            // If no active events, jump to the next event's start day.
            if (pq.isEmpty()) {
                day = events[i][0];
            }

            // Add all events that start today.
            while (i < n && events[i][0] == day) {
                pq.offer(events[i][1]);
                i++;
            }

            // Remove events that have already expired.
            while (!pq.isEmpty() && pq.peek() < day) {
                pq.poll();
            }

            // Attend the event that ends the earliest.
            if (!pq.isEmpty()) {
                pq.poll();
                ans++;
                day++;
            }
        }

        return ans;
    }
}