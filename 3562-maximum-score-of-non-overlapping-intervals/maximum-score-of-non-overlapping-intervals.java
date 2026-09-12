import java.util.*;

class Solution {

    class Node {
        long score;
        List<Integer> indices;

        Node(long score, List<Integer> indices) {
            this.score = score;
            this.indices = indices;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {

        int n = intervals.size();

        // Store: left, right, weight, originalIndex
        long[][] arr = new long[n][4];

        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals.get(i).get(0);
            arr[i][1] = intervals.get(i).get(1);
            arr[i][2] = intervals.get(i).get(2);
            arr[i][3] = i;
        }

        // Sort by starting position
        Arrays.sort(arr, (a, b) -> Long.compare(a[0], b[0]));

        // Store all left values for binary search
        long[] starts = new long[n];

        for (int i = 0; i < n; i++) {
            starts[i] = arr[i][0];
        }

        // next[i] = first interval with left > arr[i][1]
        int[] next = new int[n];

        for (int i = 0; i < n; i++) {
            next[i] = binarySearch(starts, arr[i][1]);
        }

        Node[][] dp = new Node[n + 1][5];

        // Base case
        for (int k = 0; k <= 4; k++) {
            dp[n][k] = new Node(0, new ArrayList<>());
        }

        // Bottom-up DP
        for (int i = n - 1; i >= 0; i--) {

            dp[i][0] = new Node(0, new ArrayList<>());

            for (int k = 1; k <= 4; k++) {

                // Skip current interval
                Node skip = dp[i + 1][k];

                // Take current interval
                Node nextNode = dp[next[i]][k - 1];

                List<Integer> list = new ArrayList<>(nextNode.indices);
                list.add((int) arr[i][3]);

                Collections.sort(list);

                Node take = new Node(
                    arr[i][2] + nextNode.score,
                    list
                );

                dp[i][k] = better(skip, take);
            }
        }

        List<Integer> answer = dp[0][4].indices;

        int[] result = new int[answer.size()];

        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result;
    }

    // Find first index where starts[index] > end
    private int binarySearch(long[] starts, long end) {

        int left = 0;
        int right = starts.length;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (starts[mid] > end) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    // Return better result
    private Node better(Node a, Node b) {

        if (a.score > b.score) {
            return a;
        }

        if (b.score > a.score) {
            return b;
        }

        // Same score → lexicographically smaller wins
        int size = Math.min(a.indices.size(), b.indices.size());

        for (int i = 0; i < size; i++) {

            if (!a.indices.get(i).equals(b.indices.get(i))) {

                if (a.indices.get(i) < b.indices.get(i)) {
                    return a;
                } else {
                    return b;
                }
            }
        }

        // If one is prefix of another, shorter one wins
        return a.indices.size() <= b.indices.size() ? a : b;
    }
}