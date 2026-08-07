class Solution {
    public String reverseWords(String s) {
        int i = 0;
        String[] arr = s.trim().split("\\s+");
        ArrayList<String> words = new ArrayList<>();
        for (i=arr.length-1;i>-1;i--) {
            words.add(arr[i]);
        } 
        String s1 = String.join(" ", words);
        return s1;
    }
}