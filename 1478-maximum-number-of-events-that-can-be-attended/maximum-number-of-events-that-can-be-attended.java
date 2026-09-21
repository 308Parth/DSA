class Solution {
    public int maxEvents(int[][] events) {

        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int day = 0;
        int i = 0;
        int count = 0;

        while (i < events.length || !pq.isEmpty()) {

            if (pq.isEmpty()) {
                day = events[i][0];
            }

            while (i < events.length && events[i][0] <= day) {
                pq.add(events[i][1]);
                i++;
            }

            while (!pq.isEmpty() && pq.peek() < day) {
                pq.poll();
            }

            if (!pq.isEmpty()) {
                pq.poll();
                count++;
                day++;
            }
        }

        return count;
    }
}