
class Solution {
    static final long MOD = 1_000_000_007L;
    long[][] comb = new long[1001][1001];

    public int numOfWays(int[] nums) {
        int n = nums.length;

        // Precompute combinations (nCr)
        for (int i = 0; i <= n; i++) {
            comb[i][0] = comb[i][i] = 1;

            for (int j = 1; j < i; j++) {
                comb[i][j] =
                    (comb[i - 1][j - 1] + comb[i - 1][j]) % MOD;
            }
        }

        long ans = solve(nums);
        return (int) ((ans - 1 + MOD) % MOD);
    }

    private long solve(int[] nums) {
        int n = nums.length;

        if (n <= 2) {
            return 1;
        }

        int root = nums[0];

        int[] left = new int[n];
        int[] right = new int[n];

        int l = 0, r = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] < root) {
                left[l++] = nums[i];
            } else {
                right[r++] = nums[i];
            }
        }

        int[] leftArr = new int[l];
        int[] rightArr = new int[r];

        for (int i = 0; i < l; i++) {
            leftArr[i] = left[i];
        }

        for (int i = 0; i < r; i++) {
            rightArr[i] = right[i];
        }

        long leftWays = solve(leftArr);
        long rightWays = solve(rightArr);

        long interleave = comb[l + r][l];

        return (((interleave * leftWays) % MOD)
                * rightWays) % MOD;
    }
}
