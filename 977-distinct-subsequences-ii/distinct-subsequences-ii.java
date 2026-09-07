class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1000000007;

        long[] last = new long[26];
        long ans = 0;

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';

            long newAns = (2 * ans + 1 - last[index] + MOD) % MOD;

            last[index] = ans + 1;
            ans = newAns;
        }

        return (int) ans;
    }
}