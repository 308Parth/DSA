import java.util.*;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        HashMap<Integer, boolean[]> map = new HashMap<>();

        // Store only rows having reserved seats
        for (int[] seats : reservedSeats) {
            int row = seats[0];
            int col = seats[1];

            // Seats 1 and 10 don't affect the answer
            if (col >= 2 && col <= 9) {
                if (!map.containsKey(row)) {
                    map.put(row, new boolean[11]);
                }

                map.get(row)[col] = true;
            }
        }

        // Every completely empty row can have 2 families
        int count = n * 2;

        // Check only rows that have reserved seats
        for (int row : map.keySet()) {

            boolean[] seat = map.get(row);

            boolean left =
                    !seat[2] && !seat[3] &&
                    !seat[4] && !seat[5];

            boolean middle =
                    !seat[4] && !seat[5] &&
                    !seat[6] && !seat[7];

            boolean right =
                    !seat[6] && !seat[7] &&
                    !seat[8] && !seat[9];

            if (left && right) {
                // Already counted 2 families
            }
            else if (left || middle || right) {
                // Only 1 family possible
                count--;
            }
            else {
                // No family possible
                count -= 2;
            }
        }

        return count;
    }
}