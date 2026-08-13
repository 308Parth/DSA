class Solution {
    public int largestAltitude(int[] gain) {
        int i =0;
        int count =0;
        int ans =0;
        for(i=0;i<gain.length;i++){
            count =  count+ gain[i];
            if(count > ans){
                ans = count;
            }
        }
        return ans;
    }
}