class Solution {
    public boolean predictTheWinner(int[] nums) {
        
        /*while(i<s){
            if(nums[i]>nums[s] && nums[i+1]<nums[s-1]){
                if(b==true){
                    p1 = p1+nums[i];
                    b=false;
                }
                else if(b==false){
                    p2 = p2+nums[i];
                    b=true;
                }
                i++;
            }
            else if(nums[i]<nums[s] && nums[i+1]>nums[s-1]){
                if(b==true){
                    p1 = p1+nums[s];
                    b=false;
                }
                else if(b==false){
                    p2 = p2+nums[s];
                    b=true;
                }
                s--;
            }
            else if(nums[i]>nums[s] && nums[i+1]>nums[s-1]){
                if(b==true){
                    p1 = p1+nums[i];
                    b=false;
                }
                else if(b==false){
                    p2 = p2+nums[i];
                    b=true;
                }
                i++;
            }
            else if(nums[i]<nums[s] && nums[i+1]<nums[s-1]){
                if(b==true){
                    p1 = p1+nums[s];
                    b=false;
                }
                else if(b==false){
                    p2 = p2+nums[s];
                    b=true;
                }
                s--;
                
            }
            if(i==s){
                break;
            }
        }
        if(p1>p2){
            return true;
        }
        else{
            return false;
        }*/
 
        
        int n = nums.length;

        int[][] dp = new int[n][n];

        // If only one number is left,
        // current player takes that number.
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }

        // Consider ranges of increasing length
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len <= n; i++) {
                int j = i + len - 1;

                // Take left number
                int left = nums[i] - dp[i + 1][j];

                // Take right number
                int right = nums[j] - dp[i][j - 1];

                // Current player chooses the better option
                dp[i][j] = Math.max(left, right);
            }
        }

        // Positive = Player 1 wins
        // Zero = Tie, Player 1 also wins
        // Negative = Player 1 loses
        return dp[0][n - 1] >= 0;
        
    }
}