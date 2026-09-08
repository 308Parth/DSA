class Solution {
    public int countCommas(int n) {
        int ans = 0;

        if(n < 1000){
            return 0;
        }
        else{
            ans = n-999;
            return ans;
        }
    }
}