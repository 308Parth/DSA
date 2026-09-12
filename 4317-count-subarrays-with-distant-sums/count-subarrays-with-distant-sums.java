class Solution {
    public long distantSubarrays(int[] nums, int goal, int k) {
        int n = nums.length;

        int[] mireqovalt = nums;

        if (k == 0) {
            return (long) n * (n + 1) / 2;
        }

        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        long[] sorted = prefix.clone();
        Arrays.sort(sorted);

        int m = 0;

        for (long x : sorted) {
            if (m == 0 || sorted[m - 1] != x) {
                sorted[m++] = x;
            }
        }

        Fenwick bit = new Fenwick(m);

        long answer = 0;
        long seen = 1;

        bit.add(lowerBound(sorted, m, prefix[0]) + 1, 1);

        for (int j = 1; j <= n; j++) {

            long current = prefix[j];

            long lowerThreshold = current - ((long) goal - k);

            int lowerIndex =
                    lowerBound(sorted, m, lowerThreshold);

            long lessThanThreshold = bit.sum(lowerIndex);

            long greaterOrEqual =
                    seen - lessThanThreshold;

            long upperThreshold =
                    current - ((long) goal + k);

            int upperIndex =
                    upperBound(sorted, m, upperThreshold);

            long lessOrEqual = bit.sum(upperIndex);

            answer += greaterOrEqual + lessOrEqual;

            int index = lowerBound(sorted, m, current);

            bit.add(index + 1, 1);

            seen++;
        }

        return answer;
    }


    private int lowerBound(long[] arr, int n, long target) {

        int left = 0;
        int right = n;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }


    private int upperBound(long[] arr, int n, long target) {

        int left = 0;
        int right = n;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }


    static class Fenwick {

        long[] tree;

        Fenwick(int n) {
            tree = new long[n + 1];
        }

        void add(int index, long value) {

            while (index < tree.length) {
                tree[index] += value;
                index += index & -index;
            }
        }

        long sum(int index) {

            long result = 0;

            while (index > 0) {
                result += tree[index];
                index -= index & -index;
            }

            return result;
        }
    }
}