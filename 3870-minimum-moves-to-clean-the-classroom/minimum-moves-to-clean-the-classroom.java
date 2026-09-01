import java.util.*;

class Solution {
    public int minMoves(String[] classroom, int energy) {

        int m = classroom.length;
        int n = classroom[0].length();

        // S = 2, L = 1, X = -1, . = 0, R = 3
        int[][] arr = new int[m][n];

        int rs = 0;
        int cs = 0;
        int litterCount = 0;

        // Convert classroom into int[][]
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                char ch = classroom[i].charAt(j);

                if (ch == 'S') {
                    arr[i][j] = 2;
                    rs = i;
                    cs = j;
                }
                else if (ch == 'L') {
                    arr[i][j] = 1;
                    litterCount++;
                }
                else if (ch == 'X') {
                    arr[i][j] = -1;
                }
                else if (ch == 'R') {
                    arr[i][j] = 3;
                }
                else {
                    arr[i][j] = 0;
                }
            }
        }

        // Give every litter an ID
        int[][] litterId = new int[m][n];

        for (int[] row : litterId) {
            Arrays.fill(row, -1);
        }

        int id = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (arr[i][j] == 1) {
                    litterId[i][j] = id++;
                }
            }
        }

        // If there is no litter
        if (litterCount == 0) {
            return 0;
        }

        int allCollected = (1 << litterCount) - 1;

        // row, column, energy, mask, moves
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{rs, cs, energy, 0, 0});

        // visited[row][column][energy][mask]
        boolean[][][][] visited =
            new boolean[m][n][energy + 1][1 << litterCount];

        visited[rs][cs][energy][0] = true;

        // UP, DOWN, LEFT, RIGHT
        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        while (!q.isEmpty()) {

            int[] current = q.poll();

            int r = current[0];
            int c = current[1];
            int e = current[2];
            int mask = current[3];
            int moves = current[4];

            // All litter collected
            if (mask == allCollected) {
                return moves;
            }

            // Try all 4 directions
            for (int[] dir : directions) {

                int nr = r + dir[0];
                int nc = c + dir[1];

                // Outside grid
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                    continue;
                }

                // Obstacle
                if (arr[nr][nc] == -1) {
                    continue;
                }

                // No energy to make a move
                if (e == 0) {
                    continue;
                }

                int newEnergy = e - 1;
                int newMask = mask;

                // Litter found
                if (arr[nr][nc] == 1) {

                    int litterNumber = litterId[nr][nc];

                    newMask = mask | (1 << litterNumber);
                }

                // Reset area
                if (arr[nr][nc] == 3) {
                    newEnergy = energy;
                }

                // If this state is new
                if (!visited[nr][nc][newEnergy][newMask]) {

                    visited[nr][nc][newEnergy][newMask] = true;

                    q.add(new int[]{
                        nr,
                        nc,
                        newEnergy,
                        newMask,
                        moves + 1
                    });
                }
            }
        }

        return -1;
    }
}