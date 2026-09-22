class NumMatrix {

    long[][] dp;

    public NumMatrix(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        dp = new long[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= m; j++) {

                dp[i][j] =
                    dp[i][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

        int minn = Math.min(row1, row2);
        int maxx1 = Math.max(row1, row2);

        int maxx = Math.max(col1, col2);
        int minn1 = Math.min(col1, col2);

        long ans = 0;

        for (int i = minn; i <= maxx1; i++) {

            ans += dp[i + 1][maxx + 1]
                 - dp[i + 1][minn1];
        }

        return (int) ans;
    }
}