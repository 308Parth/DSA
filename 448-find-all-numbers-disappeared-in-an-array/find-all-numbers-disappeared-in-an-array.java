class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
       
        /*int n = nums.length;
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=1;i<n+1;i++){
            int count =0;
            for(int j=0;j<n;j++){
                if(i==nums[j]){
                    count++;
                    break;
                }
            }
            if(count == 0){
                arr.add(i);
            }
        }
        return arr;*/

        int n = nums.length;
        ArrayList<Integer> arr1 = new ArrayList<>();
        int[] arr = new int[n];
        for(int i =0;i<n;i++){
            arr[i]=i+1;
        }

        for(int j =0;j<n;j++){
            int k = nums[j];
            arr[k-1]=0;
        }

        for(int i =0;i<n;i++){
            if(arr[i]!=0){
                arr1.add(arr[i]);
            }
        }
        return arr1;
    }
}