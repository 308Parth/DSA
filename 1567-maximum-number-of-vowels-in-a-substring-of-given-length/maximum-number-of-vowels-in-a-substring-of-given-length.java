class Solution {
    public int maxVowels(String s, int k) {
        String str = "";
        int count =0 ;
        int c=0;
        int p =0;

        for(int i = 0; i<s.length();i++){
            if(count<k){
                if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u'){
                    c++;
                }
                str = str + s.charAt(i);
                count++;
            }
            else if(count==k){
                if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u'){
                    c++;
                }
                if(s.charAt(i-k) == 'a' || s.charAt(i-k) == 'e' || s.charAt(i-k) == 'i' || s.charAt(i-k) == 'o' || s.charAt(i-k) == 'u'){
                    c--;
                }
                str = str + s.charAt(i);
                
            }
            if(c>p && count == k){
                p=c;
            }
        }
        return p;    

    }
}