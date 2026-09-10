class Solution {
    public int removeElement(int[] nums, int val) {
        int[] ans = new int[nums.length];
        int j =0;
        for(int i =0;i<nums.length;i++){
            if(nums[i]!=val){
                ans[j]=nums[i];
                j++;
            }
        }
        for(int i =0;i<ans.length;i++){
            nums[i]=ans[i];
        }
        return j;
    }
}