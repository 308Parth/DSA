class Solution {
    public List<List<String>> solveNQueens(int n) {

        List<List<String>> ans = new ArrayList<>();

        char[][] board = new char[n][n];

        // Initially all cells are empty
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        solve(0, n, board, ans);

        return ans;
    }

    public void solve(int row, int n, char[][] board,
                      List<List<String>> ans) {

        // All queens placed
        if (row == n) {
            List<String> temp = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                temp.add(new String(board[i]));
            }

            ans.add(temp);
            return;
        }

        // Try every column in this row
        for (int col = 0; col < n; col++) {

            if (isSafe(row, col, n, board)) {

                // Place queen
                board[row][col] = 'Q';

                // Move to next row
                solve(row + 1, n, board, ans);

                // Backtrack
                board[row][col] = '.';
            }
        }
    }

    public boolean isSafe(int row, int col, int n, char[][] board) {

        // Check same column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check upper-left diagonal
        int i = row - 1;
        int j = col - 1;

        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i--;
            j--;
        }

        // Check upper-right diagonal
        i = row - 1;
        j = col + 1;

        while (i >= 0 && j < n) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i--;
            j++;
        }

        return true;
    }
}