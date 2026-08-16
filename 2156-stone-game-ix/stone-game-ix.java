class Solution {
    public boolean stoneGameIX(int[] stones) {
        int[] re = new int[3];

        for (int stone : stones) {
            re[stone % 3]++;
        }

        if (re[0] % 2 == 0) {
            return re[1] > 0 && re[2] > 0;
        }

        return Math.abs(re[1] - re[2]) > 2;
    }
}