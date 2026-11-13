
class Solution {

    private long getCost(int l, int r, int[] nums,
                         int[][] jump, long[][] sum,
                         long[] prefix) {

        long total = 0;
        int cur = l;
        int LOG = jump.length;

        // Calculate sum of prefix maximums
        for (int j = LOG - 1; j >= 0; j--) {
            if (jump[j][cur] <= r) {
                total += sum[j][cur];
                cur = jump[j][cur];
            }
        }

        // Remaining partial segment
        total += (long) nums[cur] * (r - cur + 1);

        // Operations = prefix maximum sum - original sum
        return total - (prefix[r + 1] - prefix[l]);
    }

    public long countNonDecreasingSubarrays(int[] nums, int k) {

        int n = nums.length;

        int LOG = 1;
        while ((1 << LOG) <= n) {
            LOG++;
        }

        int[] next = new int[n];
        int[] stack = new int[n];
        int top = -1;

        // Step 1: Find next strictly greater element
        for (int i = n - 1; i >= 0; i--) {

            while (top >= 0 && nums[stack[top]] <= nums[i]) {
                top--;
            }

            next[i] = (top == -1) ? n : stack[top];

            stack[++top] = i;
        }

        // Step 2: Build binary lifting tables
        int[][] jump = new int[LOG][n];
        long[][] sum = new long[LOG][n];

        for (int i = 0; i < n; i++) {
            jump[0][i] = next[i];

            sum[0][i] = (long) nums[i] * (next[i] - i);
        }

        for (int j = 1; j < LOG; j++) {

            for (int i = 0; i < n; i++) {

                int mid = jump[j - 1][i];

                if (mid < n) {
                    jump[j][i] = jump[j - 1][mid];

                    sum[j][i] = sum[j - 1][i]
                              + sum[j - 1][mid];
                } else {
                    jump[j][i] = n;
                    sum[j][i] = sum[j - 1][i];
                }
            }
        }

        // Step 3: Prefix sum of original array
        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        // Step 4: Binary search for each right endpoint
        long ans = 0;

        for (int r = 0; r < n; r++) {

            int low = 0;
            int high = r;

            while (low < high) {

                int mid = low + (high - low) / 2;

                long cost = getCost(
                    mid, r, nums, jump, sum, prefix
                );

                if (cost <= k) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }

            ans += r - low + 1;
        }

        return ans;
    }
}




