class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int current =0;
        int prev =0;

        for(int i =0;i<nums.length;i++){
            if(nums[i]==1){
                current++;
            }
            else{
                if(current>prev){
                    prev = current;
                }
                current = 0;
            }
            if (current > prev)
            {
                prev = current;
            }
        }
        return prev;
    }
}