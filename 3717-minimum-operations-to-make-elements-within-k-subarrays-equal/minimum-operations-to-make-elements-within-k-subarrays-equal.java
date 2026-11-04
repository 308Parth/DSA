
import java.util.*;

class Solution {

    class MedianWindow {
        TreeMap<Long, Integer> low = new TreeMap<>();
        TreeMap<Long, Integer> high = new TreeMap<>();

        long lowSum = 0, highSum = 0;
        int lowSize = 0, highSize = 0;
        int target;

        MedianWindow(int x) {
            target = (x + 1) / 2;
        }

        void addLow(long v) {
            low.put(v, low.getOrDefault(v, 0) + 1);
            lowSum += v;
            lowSize++;
        }

        void addHigh(long v) {
            high.put(v, high.getOrDefault(v, 0) + 1);
            highSum += v;
            highSize++;
        }

        void removeLow(long v) {
            int c = low.get(v);
            if (c == 1) low.remove(v);
            else low.put(v, c - 1);

            lowSum -= v;
            lowSize--;
        }

        void removeHigh(long v) {
            int c = high.get(v);
            if (c == 1) high.remove(v);
            else high.put(v, c - 1);

            highSum -= v;
            highSize--;
        }

        void rebalance() {
            while (lowSize > target) {
                long v = low.lastKey();
                removeLow(v);
                addHigh(v);
            }

            while (lowSize < target && highSize > 0) {
                long v = high.firstKey();
                removeHigh(v);
                addLow(v);
            }
        }

        void add(long v) {
            if (lowSize == 0 || v <= low.lastKey()) {
                addLow(v);
            } else {
                addHigh(v);
            }

            rebalance();
        }

        void remove(long v) {
            if (low.containsKey(v)) {
                removeLow(v);
            } else {
                removeHigh(v);
            }

            rebalance();
        }

        long getCost() {
            long median = low.lastKey();

            return median * lowSize - lowSum
                 + highSum - median * highSize;
        }
    }

    public long minOperations(int[] nums, int x, int k) {

        int n = nums.length;

        long[] cost = new long[n - x + 1];

        MedianWindow window = new MedianWindow(x);

        for (int i = 0; i < x; i++) {
            window.add(nums[i]);
        }

        cost[0] = window.getCost();

        for (int i = x; i < n; i++) {
            window.remove(nums[i - x]);
            window.add(nums[i]);

            cost[i - x + 1] = window.getCost();
        }

        long INF = Long.MAX_VALUE / 2;

        long[][] dp = new long[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], INF);
            dp[i][0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {

                dp[i][j] = dp[i - 1][j];

                if (i >= x && dp[i - x][j - 1] != INF) {
                    long take = dp[i - x][j - 1]
                              + cost[i - x];

                    dp[i][j] = Math.min(dp[i][j], take);
                }
            }
        }

        return dp[n][k];
    }
}

