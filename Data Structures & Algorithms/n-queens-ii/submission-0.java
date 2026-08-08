class Solution {
    private int count;
    private boolean[] columns;
    private boolean[] positiveDiagonals;
    private boolean[] negativeDiagonals;
    public int totalNQueens(int n) {
        count = 0;
        columns = new boolean[n];
        positiveDiagonals = new boolean[2 * n - 1];
        negativeDiagonals = new boolean[2 * n - 1];
        backtrack(0, n);
        return count;
    }
    private void backtrack(int row, int n) {
        if (row == n) {
            count++;
            return;
        }
        for (int col = 0; col < n; col++) {
            int positive = row + col;
            int negative = row - col + n - 1;
            if (columns[col] || positiveDiagonals[positive] || negativeDiagonals[negative]) {
                continue;
            }
            columns[col] = true;
            positiveDiagonals[positive] = true;
            negativeDiagonals[negative] = true;
            backtrack(row + 1, n);
            columns[col] = false;
            positiveDiagonals[positive] = false;
            negativeDiagonals[negative] = false;
        }
    }
}