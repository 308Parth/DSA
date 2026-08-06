class Solution {
    int value(char c) {
            switch (c) {
                case 'I': return 1;
                case 'V': return 5;
                case 'X': return 10;
                case 'L': return 50;
                case 'C': return 100;
                case 'D': return 500;
                case 'M': return 1000;
                default: return 0;
            }
        }
    public int romanToInt(String s) {
        char[] ro = s.toCharArray();
        int i;
        int ans=0;
        for(i=0;i<s.length()-1;i++){
            if(value(ro[i])==value(ro[i+1])){
                ans = ans+value(ro[i]);
            }
            else if(value(ro[i])>value(ro[i+1])){
                ans = ans+value(ro[i]);
            }
            else if(value(ro[i])<value(ro[i+1])){
                ans = ans-value(ro[i]);
            }
        }
        ans = ans+value(ro[s.length()-1]);
        return ans;
    }
}