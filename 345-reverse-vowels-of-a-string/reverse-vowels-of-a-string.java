class Solution {
    public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder(s);
        int z;
        int j = s.length()-1;
        int a = j;
        for(z=0;z<a;z++){
            if (sb.charAt(z) == 'a' ||
                sb.charAt(z) == 'e' ||
                sb.charAt(z) == 'i' ||
                sb.charAt(z) == 'o' ||
                sb.charAt(z) == 'u' ||
                sb.charAt(z) == 'A' ||
                sb.charAt(z) == 'E' ||
                sb.charAt(z) == 'I' ||
                sb.charAt(z) == 'O' ||
                sb.charAt(z) == 'U'){
                    for(j=a;j>z;j--){
                        if (sb.charAt(j) == 'a' ||
                            sb.charAt(j) == 'e' ||
                            sb.charAt(j) == 'i' ||
                            sb.charAt(j) == 'o' ||
                            sb.charAt(j) == 'u' ||
                            sb.charAt(j) == 'A' ||
                            sb.charAt(j) == 'E' ||
                            sb.charAt(j) == 'I' ||
                            sb.charAt(j) == 'O' ||
                            sb.charAt(j) == 'U'){
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

