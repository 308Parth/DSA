class Solution {
    public int minOperations(String s) {
        int n = s.length();

        // already sorted?
        boolean sorted = true;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) < s.charAt(i - 1)) {
                sorted = false;
                break;
            }
        }
        if (sorted) return 0;

        // only substrings of length 1 are allowed, so nothing can change
        if (n == 2) return -1;

        char mn = 'z', mx = 'a';
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c < mn) mn = c;
            if (c > mx) mx = c;
        }

        // sort s[1..] or s[..n-2]
        if (s.charAt(0) == mn || s.charAt(n - 1) == mx) return 1;

        // count occurrences of min and max
        int cntMin = 0, cntMax = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == mn) cntMin++;
            if (c == mx) cntMax++;
        }

        // min appears only at the end AND max appears only at the start
        if (s.charAt(n - 1) == mn && cntMin == 1 && s.charAt(0) == mx && cntMax == 1) {
            return 3;
        }

        return 2;
    }
}


