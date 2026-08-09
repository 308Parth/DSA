class Solution {
    public int countBinaryPalindromes(long n) {
        /*
        int count = 0;

        for(int i = 0; i<=n;i++){
            String b = Integer.toBinaryString(i);
            int left = 0;
            int right = b.length() - 1;
            boolean palindrome = true;
            while(left<right){
                if(b.charAt(left) != b.charAt(right)){
                    palindrome = false;
                    break;
                }
                left++;
                right--;
            }
            if(palindrome){
                count++;
            }
        }
        return count;*/

        if (n == 0) {
            return 1;
        }

        int count = 1; // 0 is a binary palindrome

        int bits = 64 - Long.numberOfLeadingZeros(n);

        // Count palindromes having fewer bits than n
        for (int len = 1; len < bits; len++) {

            int half = (len + 1) / 2;

            count += 1 << (half - 1);
        }

        // Count palindromes having the same number of bits as n
        int half = (bits + 1) / 2;

        long prefix = n >> (bits - half);

        long start = 1L << (half - 1);

        count += prefix - start;

        // Create palindrome from prefix
        long palindrome = prefix;

        long x = (bits % 2 == 1)
                ? prefix >> 1
                : prefix;

        while (x > 0) {
            palindrome = (palindrome << 1) | (x & 1);
            x >>= 1;
        }

        // If generated palindrome is <= n, include it
        if (palindrome <= n) {
            count++;
        }

        return count;
    }
}