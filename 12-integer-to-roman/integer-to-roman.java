class Solution {
    String value(int c) {
            switch (c) {
                case 1: return "I";
                case 5: return "V";
                case 10: return "X";
                case 50: return "L";
                case 100: return "C";
                case 500: return "D";
                case 1000: return "M";
                default: return" ";
            }
        }
    public String intToRoman(int num) {
        int[] arr = new int[]{1000, 500,100,50, 10,5, 1};
        int ans = num;
        int count = 0;
        String a = "";
        int i;
        int j;
        int z;

        for(i=0 ;i<7;i++){
            count = 0;
            while(arr[i]<ans || arr[i]==ans){
                ans = ans - arr[i];
                count++;
            }
            if(count<4){
                for(j=0;j<count;j++){
                    a = a + value(arr[i]);
                }
            }
            else if(count == 4){
                a = a + value(arr[i]) + value(arr[i-1]);
            }
            else if(4<count && count<9){
                a = a + value(arr[i-1]);
                for(z=0;z<count-5;z++){
                    a = a + value(arr[i]);
                }
            }
            else if(count==9){
                a = a + value(arr[i]) + value(arr[i-2]);
            }
            i++;
        }
        return a;
    }
}