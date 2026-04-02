import java.util.*;

class Solution {
    int[][][] dp;

    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;

        dp = new int[m][n][3];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                Arrays.fill(dp[i][j], Integer.MIN_VALUE);
            }
        }

        return dfs(coins, 0, 0, 0);
    }

    int dfs(int[][] coins, int i, int j, int k) {

        // out of bounds
        if(i >= coins.length || j >= coins[0].length)
            return Integer.MIN_VALUE;

        // destination
        if(i == coins.length-1 && j == coins[0].length-1) {
            if(coins[i][j] < 0 && k < 2) return 0;
            return coins[i][j];
        }

        if(dp[i][j][k] != Integer.MIN_VALUE)
            return dp[i][j][k];

        int take = coins[i][j] + Math.max(
                dfs(coins, i+1, j, k),
                dfs(coins, i, j+1, k)
        );

        int skip = Integer.MIN_VALUE;

        if(coins[i][j] < 0 && k < 2) {
            skip = Math.max(
                    dfs(coins, i+1, j, k+1),
                    dfs(coins, i, j+1, k+1)
            );
        }

        return dp[i][j][k] = Math.max(take, skip);
    }
}