class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        int INF = 1_000_000_000; // large number instead of Integer.MAX_VALUE

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else {
                    int up = grid[i][j] + (i > 0 ? dp[i - 1][j] : INF);
                    int left = grid[i][j] + (j > 0 ? dp[i][j - 1] : INF);
                    dp[i][j] = Math.min(up, left);
                }
            }
        }
        return dp[n - 1][m - 1];
    }
}
