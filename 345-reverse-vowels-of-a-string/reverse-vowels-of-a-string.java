class Solution {
    boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
               c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
    public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder(s);
        int z;
        int j = s.length()-1;
        int a = j;
        for(z=0;z<a;z++){
            if (isVowel(sb.charAt(z))){
                    for(j=a;j>z;j--){
                        if (isVowel(sb.charAt(j))){
                                char temp = sb.charAt(z);
                                sb.setCharAt(z,sb.charAt(j));
                                sb.setCharAt(j,temp);
                                a=j-1;
                                break;
                    }
                }
            }
        }
        return sb.toString();
    }
}

