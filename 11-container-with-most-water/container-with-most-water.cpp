class Solution {
public:
    int maxArea(vector<int>& height) {
        int left = 0;
        int right = height.size() - 1;
        int len;
        int area = 0;
        int answer = 0;

        
        while(left < right){
            len = right - left;
            if(height[left] <= height[right]){
                area = height[left]*len;
                left++;
            }
            else{
                area = height[right]*len;
                right--;
            }
            if(area > answer){
                answer = area;
            }
        }
        return answer;
        
    }
};