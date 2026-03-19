class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
         int[][] X = new int[n + 1][m + 1];
        int[][] Y = new int[n + 1][m + 1];

        // Build prefix sums
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                X[i][j] = X[i-1][j] + X[i][j-1] - X[i-1][j-1];
                Y[i][j] = Y[i-1][j] + Y[i][j-1] - Y[i-1][j-1];

                if (grid[i-1][j-1] == 'X') X[i][j]++;
                if (grid[i-1][j-1] == 'Y') Y[i][j]++;
            }
        }
        int count=0;
        int[][] prefix=new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(X[i][j]==Y[i][j] && X[i][j]>0 && Y[i][j]>0){
                    count++;
                }
            }
        }
        return count;
    }
}