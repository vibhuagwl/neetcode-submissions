class Solution {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, i, j, visited, word, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int r, int c, boolean[][] visited, String word, int index) {
        if (index == word.length()) {
            return true;
        }

        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || visited[r][c]
            || board[r][c] != word.charAt(index)) {
            return false;
        }

        visited[r][c] = true;

        for (int d = 0; d < 4; d++) {
            int nr = r + dx[d];
            int nc = c + dy[d];

            if (dfs(board, nr, nc, visited, word, index + 1)) {
                visited[r][c] = false; // backtrack
                return true;
            }
        }

        visited[r][c] = false; // backtrack
        return false;
    }
}