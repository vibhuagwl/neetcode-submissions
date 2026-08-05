class Solution {
    public int numIslands(char[][] grid) {
        int island = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    bfs(grid, r, c);
                    island++;
                }
            }
        }
        return island;
    }

    private void bfs(char[][] grid, int startR, int startC) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {startR, startC});
        grid[startR][startC] = '0';
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];
            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr >= 0 && nc >= 0 && nr < grid.length
                    && nc < grid[0].length && grid[nr][nc] == '1') {
                    queue.offer(new int[] {nr, nc});
                    grid[nr][nc] = '0';
                }
            }
        }
    }
    private void dfs(char[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }
}
