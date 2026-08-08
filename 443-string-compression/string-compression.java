class Solution {
    public int compress(char[] chars) {
        ArrayList<Character> arr = new ArrayList<>();

        int i = 0;

        while (i < chars.length) {
            char ch = chars[i];
            int count = 0;

            while (i < chars.length && chars[i] == ch) {
                count++;
                i++;
            }

            arr.add(ch);

            if (count > 1) {
                String s = String.valueOf(count);

                for (int j = 0; j < s.length(); j++) {
                    arr.add(s.charAt(j));
                }
            }
        }

        // Put compressed result back into chars
        for (int j = 0; j < arr.size(); j++) {
            chars[j] = arr.get(j);
        }

        return arr.size();
    }
}