
import java.util.*;

class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {

        TreeSet<Integer> available = new TreeSet<>();

        PriorityQueue<long[]> busy = new PriorityQueue<>(
            (a, b) -> Long.compare(a[0], b[0])
        );

        int[] count = new int[k];

        // Initially all servers are available
        for (int i = 0; i < k; i++) {
            available.add(i);
        }

        for (int i = 0; i < arrival.length; i++) {

            // Release servers whose tasks are completed
            while (!busy.isEmpty() && busy.peek()[0] <= arrival[i]) {
                long[] server = busy.poll();
                available.add((int) server[1]);
            }

            // If all servers are busy, drop the request
            if (available.isEmpty()) {
                continue;
            }

            // Find the next available server
            int serverId = i % k;

            Integer assigned = available.ceiling(serverId);

            // Wrap around if no server is available after serverId
            if (assigned == null) {
                assigned = available.first();
            }

            // Assign request
            available.remove(assigned);

            count[assigned]++;

            // Store finishing time and server ID
            busy.offer(new long[]{
                (long) arrival[i] + load[i],
                assigned
            });
        }

        // Find maximum requests handled
        int max = 0;

        for (int c : count) {
            max = Math.max(max, c);
        }

        // Collect busiest servers
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            if (count[i] == max) {
                result.add(i);
            }
        }

        return result;
    }
}
