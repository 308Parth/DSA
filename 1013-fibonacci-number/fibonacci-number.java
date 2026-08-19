class Solution {
    public int fib(int n) {
        int pre0 = 0;
        int pre1 = 1; 
        int ans = 1;
        if(n==0){
            return 0;
        }
        for(int i=1;i<n;i++){
            ans = pre1+pre0;
            pre0 = pre1;
            pre1=ans;
        }
        return ans;
    }
}