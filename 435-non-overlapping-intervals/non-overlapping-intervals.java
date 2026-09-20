class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int count = 0;
        int lastEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] >= lastEnd) {
                // No overlap
                lastEnd = intervals[i][1];
            } else {
                // Overlap → remove this interval
                count++;
            }
        }

        return count;
    }
}