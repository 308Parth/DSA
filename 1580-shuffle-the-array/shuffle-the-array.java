class Solution {
    public int[] shuffle(int[] nums, int n) {
        int i =0;
        int m = n+n;
        int c =0;
        int j = n;
        int[] arr = new int[m];
        while(c<m){
            if(c%2==0){
                arr[c]=nums[i];
                i++;
            }
            else{
                arr[c]=nums[j];
                j++;
            }
            c++;
        }
        return arr;
    }
}