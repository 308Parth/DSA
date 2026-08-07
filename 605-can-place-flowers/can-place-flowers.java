class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i =0 ;
        int count = 0;
        int l =flowerbed.length;

        for(i=0;i<flowerbed.length;i++){
            if(l==1&&flowerbed[i]==0){
                flowerbed[i] = 1;
                count++;
            }
            if(flowerbed[i]==0 && l!=1){
                if(i != 0 && i != l-1 && flowerbed[i-1]==0 && flowerbed[i+1]==0){
                    flowerbed[i] = 1;
                    count++;
                }
                else if(i==0 && flowerbed[i]==0 && flowerbed[i+1]==0 ){
                    flowerbed[i] = 1;
                    count++;
                }
                else if(i==l-1 && flowerbed[i]==0 && flowerbed[i-1]==0){
                    flowerbed[i] = 1;
                    count++;
                }
            }
        }
        if(count>=n){
            return true;
        }
        else{
            return false;
        }
    }
}