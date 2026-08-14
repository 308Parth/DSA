class Solution {
    public boolean closeStrings(String word1, String word2) {
        int w1 = word1.length();
        int w2 = word2.length();

        if(w1!=w2){
            return false;
        }

        char[] wo1 = word1.toCharArray();
        char[] wo2 = word2.toCharArray();

        Set<Integer> s1 = new HashSet<>();
        for(int num : wo1){
            s1.add(num);
        }

        int[] arr1 = new int[s1.size()];
        int i =0;
        for(int num : s1){
            arr1[i] = num;
            i++;
        }

        Set<Integer> s2 = new HashSet<>();
        for(int num : wo2){
            s2.add(num);
        }

        int[] arr2 = new int[s2.size()];
        i =0;
        for(int num : s2){
            arr2[i] = num;
            i++;
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        if(arr1.length != arr2.length){
            return false;
        }

        for(i=0; i<arr1.length; i++){
            if(arr1[i] != arr2[i]){
                return false;
            }
        }

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for(i = 0; i < word1.length(); i++){
            freq1[word1.charAt(i) - 'a']++;
        }

        for(i = 0; i < word2.length(); i++){
            freq2[word2.charAt(i) - 'a']++;
        }

        Arrays.sort(freq1);
        Arrays.sort(freq2);

        if(!Arrays.equals(freq1, freq2)){
            return false;
        }

    return true;
    }
}