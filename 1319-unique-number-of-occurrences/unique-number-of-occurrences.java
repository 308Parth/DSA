class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        
        Set<Integer> set1 = new HashSet<>();

        for (int num : arr) {
            set1.add(num);
        }

        int[] num1 = new int[set1.size()];

        int i = 0;
        for (int num : set1) {
            num1[i++] = num;
        }

        int[] count = new int [num1.length];
        int c =0;

        for(i=0;i<num1.length;i++){
            c=0;
            for(int j=0;j<arr.length;j++){
                if(num1[i]==arr[j]){
                    c++;
                }
            }
            count[i] = c;
        }
        for(i=0;i<count.length;i++){
            for(int j=i+1;j<count.length;j++){
                if(count[i]==count[j]){
                    return false;
                }
            }
        }
        return true;
    }
}