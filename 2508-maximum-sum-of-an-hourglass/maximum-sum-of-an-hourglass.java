class Solution {
    public int maxSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if(n<3&&m<3){
            return -1;
        }
        int sum = 0;
        int ans = Integer.MIN_VALUE;
        
        for(int i = 0; i < n-2 ;i++){
            for(int j= 0; j< m-2;j++){
                sum = grid[i][j]+grid[i][j+1]+grid[i][j+2]+grid[i+1][j+1]+grid[i+2][j]+grid[i+2][j+1]+grid[i+2][j+2];

                if(sum>ans){
                    ans = sum;
                } 
            }
        }
        return ans;
    }
}