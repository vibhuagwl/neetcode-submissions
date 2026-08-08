class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        boolean[] usedColumn = new boolean[n];
        boolean[] usedDiagonal = new boolean[2 * n - 1];
        boolean[] usedAntiDiagonal = new boolean[2 * n - 1];

        backtrack(0, n, board, usedColumn, usedDiagonal, usedAntiDiagonal, result);

        return result;
    }

    private void backtrack(int row, int n, char[][] board, boolean[] usedColumn,
        boolean[] usedDiagonal, boolean[] usedAntiDiagonal, List<List<String>> result) {
        if (row == n) {
            List<String> solution = new ArrayList<>();

            for (char[] boardRow : board) {
                solution.add(new String(boardRow));
            }

            result.add(solution);
            return;
        }

        for (int col = 0; col < n; col++) {
            int diagonal = row + col;
            int antiDiagonal = row - col + n - 1;

            if (usedColumn[col] || usedDiagonal[diagonal] || usedAntiDiagonal[antiDiagonal]) {
                continue;
            }

            // Place queen
            board[row][col] = 'Q';
            usedColumn[col] = true;
            usedDiagonal[diagonal] = true;
            usedAntiDiagonal[antiDiagonal] = true;

            backtrack(row + 1, n, board, usedColumn, usedDiagonal, usedAntiDiagonal, result);

            // Remove queen
            board[row][col] = '.';
            usedColumn[col] = false;
            usedDiagonal[diagonal] = false;
            usedAntiDiagonal[antiDiagonal] = false;
        }
    }
}
