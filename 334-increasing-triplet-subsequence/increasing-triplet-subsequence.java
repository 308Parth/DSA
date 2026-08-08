class Solution {
    public boolean increasingTriplet(int[] nums) {
        int i =0;
        int j =0;
        int k=0;
        int s =nums.length;
        /*if(s>2){
            for(i=0;i<s-2;i++){
                for(j=i+1;j<s-1;j++){
                    if((nums[i]<nums[j])&&i<j){
                        for(k=s-1;k>j;k--){
                            if((nums[j]<nums[k])&&j<k){
                                return true;
                            }
                        }
                    } 
                }
            }
        }
        else{
            return false;
        }
        return false;*/
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;

        for(i=0;i<nums.length;i++){
            if(nums[i]<=a){
                a=nums[i];
            }
            else if(nums[i]<=b){
                b=nums[i];
            }
            else{
                return true;
            }
        }
        return false;
    }   
}