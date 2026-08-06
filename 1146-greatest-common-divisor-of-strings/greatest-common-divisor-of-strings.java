class Solution {

    public String gcdOfStrings(String str1, String str2) {

        int i = 0;

        StringBuilder sb = new StringBuilder();

        // Common Prefix
        while (i < str1.length() &&
               i < str2.length() &&
               str1.charAt(i) == str2.charAt(i)) {

            sb.append(str1.charAt(i));
            i++;
        }

        String prefix = sb.toString();

        // Try biggest prefix first
        for (int len = prefix.length(); len >= 1; len--) {

            if (str1.length() % len != 0 || str2.length() % len != 0)
                continue;

            String candidate = prefix.substring(0, len);

            if (isDivisible(str1, candidate) &&
                isDivisible(str2, candidate)) {

                return candidate;
            }
        }

        return "";
    }

    private boolean isDivisible(String str, String candidate) {

        int len = candidate.length();

        for (int i = 0; i < str.length(); i += len) {

            if (!str.substring(i, i + len).equals(candidate))
                return false;
        }

        return true;
    }
}