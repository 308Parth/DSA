
import java.util.*;

class Solution {
    public String predictPartyVictory(String senate) {

        Queue<Integer> rQueue = new LinkedList<>();
        Queue<Integer> dQueue = new LinkedList<>();

        int n = senate.length();

        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                rQueue.offer(i);
            } else {
                dQueue.offer(i);
            }
        }

        while (!rQueue.isEmpty() && !dQueue.isEmpty()) {

            int r = rQueue.poll();
            int d = dQueue.poll();

            if (r < d) {
                rQueue.offer(r + n);
            } else {
                dQueue.offer(d + n);
            }
        }

        return rQueue.isEmpty() ? "Dire" : "Radiant";
    }
}
