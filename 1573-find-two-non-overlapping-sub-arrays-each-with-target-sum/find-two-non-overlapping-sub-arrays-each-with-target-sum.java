class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] len = new int[n];
        int[] best = new int[n];

        for (int i = 0; i < n; i++) {
            len[i] = Integer.MAX_VALUE;
            best[i] = Integer.MAX_VALUE;
        }

        int sum = 0;
        int j = 0;
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            sum += arr[i];

            
            while (sum > target) {
                sum -= arr[j];
                j++;
            }

            
            if (i > 0) {
                best[i] = best[i - 1];
            }

            
            if (sum == target) {

                int currentLength = i - j + 1;

                
                if (j > 0 && best[j - 1] != Integer.MAX_VALUE) {
                    answer = Math.min(
                        answer,
                        currentLength + best[j - 1]
                    );
                }

                
                len[i] = currentLength;

                
                best[i] = Math.min(best[i], len[i]);
            }
        }

        if (answer == Integer.MAX_VALUE) {
            return -1;
        }

        return answer;
    }
}