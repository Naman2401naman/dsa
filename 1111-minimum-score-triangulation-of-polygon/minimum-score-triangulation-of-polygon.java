class Solution {
    int[][] dp;

    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(values, 0, n - 1);
    }

    private int solve(int[] values, int i, int j) {
        if (j - i < 2) return 0;  // less than 3 points → no triangle
        if (dp[i][j] != -1) return dp[i][j];

        int ans = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            ans = Math.min(ans,
                solve(values, i, k) +
                values[i] * values[k] * values[j] +
                solve(values, k, j));
        }
        return dp[i][j] = ans;
    }
}
