class Solution {
    public boolean isSubsequence(String s, String t) {
        int sl = s.length();
        int tl = t.length();
        int count = 0;
        String str = "";
        int c = 0;

        for(int i = 0; i<sl; i++){
            for(int j=c; j<tl; j++){
                if(s.charAt(i)==t.charAt(j)){
                    str = str + t.charAt(j); 
                    c = j+1;
                    count++;
                    break;
                    
                }
            }
        }
        if(count==sl && s.equals(str)){
            return true;
        }
        else{
            return false;
        }
    }
}