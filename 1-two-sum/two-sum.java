class Solution {
    public int[] twoSum(int[] nums, int target) {
        ArrayList<Integer> v = new ArrayList<>();
        int i;
        int j;
        for(i=0;i<nums.length;i++){
            for(j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j] == target ){
                    v.add(i);
                    v.add(j);
                }
            }
        }
        int[] ans = new int[v.size()];
        int z;
        for(z=0; z<v.size();z++){
            ans[z]=v.get(z);
        }

        return ans;
    }
}