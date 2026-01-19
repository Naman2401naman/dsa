class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][] row = new int[m + 1][n + 1];
        int[][] col = new int[m + 1][n + 1];
        int[][] diag1 = new int[m + 1][n + 1];
        int[][] diag2 = new int[m + 2][n + 2];

        // Prefix sums
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                row[i + 1][j + 1] = row[i + 1][j] + grid[i][j];
                col[i + 1][j + 1] = col[i][j + 1] + grid[i][j];
                diag1[i + 1][j + 1] = diag1[i][j] + grid[i][j];
                diag2[i + 1][j + 1] = diag2[i][j + 2] + grid[i][j];
            }
        }

        int max = 1;

        for (int size = Math.min(m, n); size >= 2; size--) {
            for (int i = 0; i + size <= m; i++) {
                for (int j = 0; j + size <= n; j++) {

                    int target = row[i + 1][j + size] - row[i + 1][j];

                    boolean ok = true;

                    // rows
                    for (int r = 0; r < size; r++) {
                        if (row[i + r + 1][j + size] - row[i + r + 1][j] != target) {
                            ok = false; break;
                        }
                    }

                    // columns
                    for (int c = 0; c < size; c++) {
                        if (col[i + size][j + c + 1] - col[i][j + c + 1] != target) {
                            ok = false; break;
                        }
                    }

                    // diagonals
                    if (diag1[i + size][j + size] - diag1[i][j] != target ||
                        diag2[i + size][j + 1] - diag2[i][j + size + 1] != target) {
                        ok = false;
                    }

                    if (ok) return size;
                }
            }
        }
        return max;
    }
}
