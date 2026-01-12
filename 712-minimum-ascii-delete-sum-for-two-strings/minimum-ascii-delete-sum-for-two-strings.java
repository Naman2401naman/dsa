class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int s1total=0;
        int s2total=0;
        int [][]dp=new int[s1.length()+1][s2.length()+1];
        for(int i=0;i<s1.length();i++){
            s1total+=(int)s1.charAt(i);
        }
        for(int i=0;i<s2.length();i++){
            s2total+=(int)s2.charAt(i);
        }
            
        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]+=dp[i-1][j-1]+(int)s1.charAt(i-1);
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        int result=(s1total+s2total)-(2*dp[s1.length()][s2.length()]);
        return result;
    }
}