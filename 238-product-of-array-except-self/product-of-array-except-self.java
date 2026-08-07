class Solution {
    public int[] productExceptSelf(int[] nums) {
        int i = 0;
        int a = 1;
        int j =0;
        int count =0;
        int c =0;
        int[] result = new int[nums.length];
        
        /*for(i=0;i<nums.length;i++){
            a=1;
            for(j=0;j<nums.length;j++){
                if(i!=j){
                    a = a*nums[j];
                }
            }
            result[i] = a;
        }*/
        for(i=0;i<nums.length;i++){
            if(nums[i]!=0){
                a=a*nums[i];
                c++;
            }
            else if(nums[i]==0){
                count++;
            }
        }
        if(count != nums.length){
            j=a;
        }
        for(i=0;i<nums.length;i++){
            if(nums[i]!=0 && count ==0){
                a = j/nums[i];
                result[i] = a;
            }
            else if(nums[i]==0&&count==1){
                result[i] = j;
            }
            else if(count>1){
                result[i]=0;
            }

        }
        return result;
        
    }
}