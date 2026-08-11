class Solution {
    public int longestSubarray(int[] nums) {
        int c = 0;
        int i =0;
        int ans =0;
        int j =0;
        for(j = 0; j<nums.length;j++){
            if (nums[j] == 0) {
                c++;
            }

            while (c > 1) {
                if (nums[i] == 0) {
                    c--;
                }
                i++;
            }

            int count = j - i ;

            if (count > ans) {
                ans = count;

            }
        }
        
        return ans;
    }
}