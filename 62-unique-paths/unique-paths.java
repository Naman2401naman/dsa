class Solution {
    public int lavde(int m, int n, int[][] dp){
        if(m == 1 || n == 1) return 1;
        if(dp[m][n] != -1) return dp[m][n];
        int totalright = lavde(m-1, n, dp);
        int totaldown = lavde(m, n-1, dp);
        dp[m][n] = totalright + totaldown;
        return dp[m][n];
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1]; 
        for(int i = 0; i<m+1; i++){
            for(int j = 0; j<n+1; j++){
                dp[i][j] = -1;
            }
        }
        return lavde(m,n,dp);   
    }
}