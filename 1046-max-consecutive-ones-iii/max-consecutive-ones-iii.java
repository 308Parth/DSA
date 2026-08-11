class Solution {
    public int longestOnes(int[] nums, int k) {

        int i = 0;
        int c = 0;
        int ans = 0;

        for (int j = 0; j < nums.length; j++) {

            if (nums[j] == 0) {
                c++;
            }

            while (c > k) {
                if (nums[i] == 0) {
                    c--;
                }
                i++;
            }

            int count = j - i + 1;

            if (count > ans) {
                ans = count;
            }
        }

        return ans;
    }
}