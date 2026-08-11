class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int l = nums.length;
        double max =  Double.NEGATIVE_INFINITY;
        double b = 0;
        double ans = 0;
        int count = 0;

        if(l<k){
            return -1;
        }
        else if(l==k){
            for(int i = 0;i<k;i++){
                ans = ans + nums[i];
            }
            double a = ans/k;
            return a;
        }
        else{
            for(int i = 0; i<l ; i++){
                /*for(int j =i ;j<k+i ;j++){
                    b = b + nums[j];
                }
                if(b>max){
                    max =b;
                }
                b =0;*/

                if(count<k){
                    b = b + nums[i];
                    count++;
                }
                else if(count == k){
                    b = b+nums[i]-nums[i-k];
                }

                if(b>max && count == k){
                    max =b;
                }
            }
        }
        double c  = max/k;
        return c;
    }
}