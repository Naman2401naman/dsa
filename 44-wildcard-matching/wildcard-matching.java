class Solution {
    public boolean isMatch(String s, String p) {
        int m=s.length();
        int n=p.length();
        boolean[][] dp=new boolean[n+1][m+1];
        dp[0][0]=true;
        for(int i=1;i<=m;i++){
            dp[0][i]=false;
        }
        for(int j=1;j<=n;j++){
            boolean flag=true;
            for(int ii=1;ii<=j;ii++){
                if(p.charAt(ii-1)!='*'){
                    flag=false;
                }
            }
            dp[j][0]=flag;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(p.charAt(i-1)==s.charAt(j-1) || p.charAt(i-1)=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }else if(p.charAt(i-1)=='*'){
                    dp[i][j]=dp[i-1][j] | dp[i][j-1];
                }else{
                    dp[i][j]=false;
                }
            }
        }
        return dp[n][m];
    }
}