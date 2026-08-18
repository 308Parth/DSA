class Solution {
    public int largestInteger(int[] nums, int k) {

        int answer = -1;

        for (int x = 0; x <= 50; x++) {

            int count = 0;

            // Start of every subarray of size k
            for (int i = 0; i <= nums.length - k; i++) {

                boolean found = false;

                // Check the current subarray
                for (int j = i; j < i + k; j++) {

                    if (nums[j] == x) {
                        found = true;
                        break;
                    }
                }

                // x appears in this subarray
                if (found) {
                    count++;
                }
            }

            // x appears in exactly one subarray
            if (count == 1) {
                answer = Math.max(answer, x);
            }
        }

        return answer;
    }
}