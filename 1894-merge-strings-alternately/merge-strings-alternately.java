class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i= 0;
        int j =0;
        
        StringBuilder sb = new StringBuilder();

        while(i < word1.length() && j < word2.length()){
            sb.append(word1.charAt(i++));
            sb.append(word2.charAt(j++));
        }
        if(j<word2.length()){
            while(j < word2.length()){
            sb.append(word2.charAt(j++));
            }
        }
        else if(i<word1.length()){
            while(i < word1.length()){
            sb.append(word1.charAt(i++));
            }
        }

        return sb.toString();
    }
}