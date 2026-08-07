class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        ArrayList<Boolean> result = new ArrayList<>();
        int i;
        int max = candies[0];
        for (i = 1; i < candies.length; i++) {
            if (candies[i] > max) {
                max = candies[i];
            }
        }   
        for(i=0;i<candies.length;i++){
            if(candies[i]+extraCandies>=max){
                result.add(true);
            }
            else{
                result.add(false);
            }
        }
        return result;
    }
}