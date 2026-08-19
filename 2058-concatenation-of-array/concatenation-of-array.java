class Solution {
    public int[] getConcatenation(int[] nums) {
        int l = nums.length;
        int count =0;
        int[] arr = new int[l+l];
        int i = 0;
        int a= 0;
        while(i<l){
            arr[a] = nums[i];
            a++;
            i++;
            if(i==l && count==0){
                i=0;
                count++;
            }
        }
        return arr;
    }
}